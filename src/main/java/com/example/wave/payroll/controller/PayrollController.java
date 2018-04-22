package com.example.wave.payroll.controller;

import com.example.wave.payroll.model.PayrollReportModel;
import com.example.wave.payroll.persistence.PayrollReport;
import com.example.wave.payroll.service.PayrollService;
import com.example.wave.payroll.util.Constants;
import com.example.wave.payroll.util.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PayrollController {

    static Logger log = LoggerFactory.getLogger(PayrollController.class);

    @Autowired
    PayrollService payrollService;

    @GetMapping("/payroll")
    public String hello(Model model) {
        log.info("Get Payroll");
        DateFormat dateFormat = new SimpleDateFormat(Constants.DateFormat);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        List<PayrollReport> reports = payrollService.getReport();
        List<PayrollReportModel> list = new ArrayList<>();
        for (PayrollReport payrollReport : reports) {
            PayrollReportModel payrollReportModel = new PayrollReportModel();
            payrollReportModel.setEmployeeId(payrollReport.getEmployeeId().toString());
            payrollReportModel.setPayPeriod(dateFormat.format(payrollReport.getStartDate()) + " - " + dateFormat.format(payrollReport.getEndDate()));
            payrollReportModel.setAmountPaid("$" + decimalFormat.format(payrollReport.getAmountPaid()));
            log.info(payrollReportModel.toString());
            list.add(payrollReportModel);
        }
        model.addAttribute("list", list);
        return "payroll";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
        log.info("Uploading file: " + multipartFile.getOriginalFilename());

        if (multipartFile.getOriginalFilename().isEmpty()) {
            redirectAttributes.addFlashAttribute("msg", ErrorMessage.NoFileSelected);
            return "redirect:/payroll";
        }

        if (!multipartFile.getContentType().equalsIgnoreCase("text/csv")) {
            redirectAttributes.addFlashAttribute("msg", ErrorMessage.InvalidFileType);
            return "redirect:/payroll";
        }

        String result = "";
        try {
            result = payrollService.uploadAndSaveRecord(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(ErrorMessage.CSVError + "Exception Message: " + e.getMessage());
            redirectAttributes.addFlashAttribute("msg", ErrorMessage.CSVError);
            redirectAttributes.addFlashAttribute("exception", e.getMessage());
            return "redirect:/payroll";
        }

        if (Constants.Success.equalsIgnoreCase(result)) {
            redirectAttributes.addFlashAttribute("msg", Constants.SuccessMessage);
            return "redirect:/payroll";
        } else {
            redirectAttributes.addFlashAttribute("msg", ErrorMessage.Error + ": " + result);
            return "redirect:/payroll";
        }
    }
}
