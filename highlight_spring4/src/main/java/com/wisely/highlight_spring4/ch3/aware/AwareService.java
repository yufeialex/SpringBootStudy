package com.wisely.highlight_spring4.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
//1 实现这两个接口可以有Bean名称和资源加载的服务
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {//2
        this.loader = resourceLoader;
    }

    @Override
    public void setBeanName(String name) {//3
        this.beanName = name;
    }

    public void outputResult() {
        System.out.println("Bean的名称为：" + beanName);

        Resource resource =
                loader.getResource("classpath:com/wisely/highlight_spring4/ch3/aware/test.txt");
        try {

            System.out.println("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
