package com.wisely.highlight_spring4.ch3.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //1 在JUint环境下提供Spring TestContext Framework的功能
@ContextConfiguration(classes = {TestConfig.class}) //2 加载配置ApplicationContext，classes属性用于加载配置类
@ActiveProfiles("prod") //3 声明活动的profile
public class DemoBeanIntegrationTests {
	@Autowired //4 可以使用普通的@Autowire注入Bean
	private TestBean testBean;

	@Test //5
	public void prodBeanShouldInject(){
		String expected = "from production profile";
		String actual = testBean.getContent();
		Assert.assertEquals(expected, actual);
	}

	
}
