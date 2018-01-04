package com.wisely.highlight_springmvc4.service;

import org.springframework.stereotype.Service;

@Service
public class StarService {
    public String getStarName(String word) {
        return "star is " + word + " !";
    }

}
