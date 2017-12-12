package com.wisely.spring_boot_starter_demoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoDBServiceProperties.class)
@ConditionalOnClass(DemoDBService.class)
@ConditionalOnProperty(prefix = "demoDB", value = "enabled", matchIfMissing = true)
public class DemoDBServiceAutoConfiguration {
    @Autowired
    private DemoDBServiceProperties demoDBServiceProperties;

    @Bean
    @ConditionalOnMissingBean(DemoDBService.class)
    public DemoDBService helloService() {
        DemoDBService demoDBService = new DemoDBService();
        demoDBService.setIp(demoDBServiceProperties.getIp());
        demoDBService.setPort(demoDBServiceProperties.getPort());
        return demoDBService;
    }
}
