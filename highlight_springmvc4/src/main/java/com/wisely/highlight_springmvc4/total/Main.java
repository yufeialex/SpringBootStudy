package com.wisely.highlight_springmvc4.total;


import com.wisely.highlight_springmvc4.total.conf.TotalConfig;
import com.wisely.highlight_springmvc4.total.controller.CompanyController;
import com.wisely.highlight_springmvc4.total.controller.SeriesController;
import com.wisely.highlight_springmvc4.total.controller.StarController;
import com.wisely.highlight_springmvc4.total.service.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(); // 这里先不注册配置类

        context.getEnvironment().setActiveProfiles("dev"); //1 将活动的profile设置为prod
        context.register(TotalConfig.class);//2后置注册Bean配置类，不然会报Bean未定义的错误
        context.refresh(); //3 刷新容器

        StarController starController1 = context.getBean(StarController.class);
        StarController starController2 = context.getBean(StarController.class);
        SeriesController seriesController = context.getBean(SeriesController.class);
        CompanyController companyController = context.getBean(CompanyController.class);

        logger.info("s1与s2是否相等：{}", starController1.equals(starController2));

        logger.info(starController1.SayHello("world"));
        logger.info(seriesController.SayHello());
        logger.info(companyController.SayHello("world"));

        for (int i = 0; i < 10; i++) {
            seriesController.executeAsyncTask(i);
            seriesController.executeAsyncTaskPlus(i);
        }

        ListService listService = context.getBean(ListService.class);


        logger.info(context.getEnvironment().getProperty("os.name")
                + "系统下的列表命令为: "
                + listService.showListCmd());

//不加的时候能看到定时任务，加上了能看到销毁函数的打印
//        context.close();
    }
}
