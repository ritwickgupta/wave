package com.example.wave.payroll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PayrollController {

    static Logger log = LoggerFactory.getLogger(PayrollController.class);

    @RequestMapping("/payroll")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        log.info("Get Payroll");
        model.addAttribute("name", name);
        return "payroll";
    }
}
