package com.wisely.highlight_springmvc4.total.service;

public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }

}
