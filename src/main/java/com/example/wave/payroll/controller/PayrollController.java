package com.example.wave.payroll.controller;

import com.example.wave.payroll.service.PayrollService;
import com.example.wave.payroll.util.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
public class PayrollController {

    static Logger log = LoggerFactory.getLogger(PayrollController.class);

    @Autowired
    PayrollService payrollService;

    @GetMapping("/payroll")
    public String hello(Model model) {
        log.info("Get Payroll");
        return "payroll";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipartFile, Model model) {
        log.info("Uploading file: " + multipartFile.getOriginalFilename());
        String result = "";
        try {
            result = payrollService.uploadAndSaveRecord(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(ErrorMessage.CSVError + "Exception Message: " + e.getMessage());
            model.addAttribute("msg", ErrorMessage.CSVError);
            model.addAttribute("exception", e.getMessage());
            return "redirect:/payroll";
        }

        model.addAttribute("msg", ErrorMessage.CSVError);
        return "redirect:/payroll";
    }
}
