package com.wisely.highlight_springmvc4.controller;

import com.wisely.highlight_springmvc4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class NormalController {
    @Autowired
    DemoService demoService;


    @RequestMapping("/normal")
    public String testPage(Model model) {
        model.addAttribute("msg", demoService.saySomething());
        return "page";
    }

}
