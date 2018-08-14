package com.wisely.highlight_springmvc4.total.service;

public class LinuxListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }

}
