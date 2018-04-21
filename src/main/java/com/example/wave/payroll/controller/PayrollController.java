package com.example.wave.payroll.controller;

import com.example.wave.payroll.service.PayrollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        log.info("Uploading file: " + file.getOriginalFilename());
        return "redirect:/payroll";
    }
}
