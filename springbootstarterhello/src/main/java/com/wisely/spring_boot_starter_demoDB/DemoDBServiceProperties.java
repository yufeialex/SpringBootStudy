package com.wisely.spring_boot_starter_demoDB;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demoDB")
public class DemoDBServiceProperties {
    private static final String IP = "127.0.0.1";
    private static final String PORT = "8877";
    private String ip = IP;
    private String port = PORT;

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
