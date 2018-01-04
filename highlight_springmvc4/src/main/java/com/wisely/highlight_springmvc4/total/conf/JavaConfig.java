package com.wisely.highlight_springmvc4.total.conf;


import com.wisely.highlight_springmvc4.total.condition.LinuxCondition;
import com.wisely.highlight_springmvc4.total.condition.WindowsCondition;
import com.wisely.highlight_springmvc4.total.controller.CompanyController;
import com.wisely.highlight_springmvc4.total.controller.SeriesController;
import com.wisely.highlight_springmvc4.total.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // 这里不用@ComponentScan，不用注解配置，用java配置
public class JavaConfig {

    @Bean
    public CompanyService companyService() {
        return new CompanyService();
    }

    // 注意Bean注解这两个属性；init和destroy是Bean的方法名
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Profile("dev")
    public SeriesService devSeriesService() {
        return new SeriesService("from development profile");
    }

    // 注意Bean注解这两个属性；init和destroy是Bean的方法名
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Profile("prod")
    public SeriesService prodSeriesService() {
        return new SeriesService("from production profile");
    }

    @Bean
    public CompanyController useFunctionService2() {
        CompanyController companyController = new CompanyController();
        companyController.setFunctionService(companyService()); // 注入方式1，构造器注入
        return companyController;
    }

	@Bean
    //注入方式2，如果某个Bean已经在容器中，可以作为参数放入另一个Bean的声明方法中
	public SeriesController useFunctionService3(SeriesService seriesService){
		SeriesController seriesController = new SeriesController();
		seriesController.setFunctionService(seriesService);
		return seriesController;
	}

    @Bean
    @Conditional(WindowsCondition.class) //1 继承条件类，如果返回真值就实例化
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class) //2
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
