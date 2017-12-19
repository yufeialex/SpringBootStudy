package com.wisely.spring_boot_starter_demoDB;


public class DemoDBService {
    private String ip;
    private String port;

    public String connect() {
        return "try connect ip:" + ip + " and port:" + port + ", and success!";
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
