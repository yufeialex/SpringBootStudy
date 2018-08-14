package com.wisely.highlight_springmvc4.total.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class StarService {
    public String getStarName(String word) {
        return "star is " + word + " !";
    }

}
