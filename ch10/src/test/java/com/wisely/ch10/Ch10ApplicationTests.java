package com.wisely.ch10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Ch10Application.class)
@WebAppConfiguration
public class Ch10ApplicationTests {

    @Test
    public void contextLoads() {
    }

}
