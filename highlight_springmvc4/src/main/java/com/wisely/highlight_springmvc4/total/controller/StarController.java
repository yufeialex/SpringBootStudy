package com.wisely.highlight_springmvc4.total.controller;

import com.wisely.highlight_springmvc4.total.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class StarController {
    @Autowired
    StarService starService;

    public String SayHello(String word) {
        return starService.getStarName(word);
    }

}
