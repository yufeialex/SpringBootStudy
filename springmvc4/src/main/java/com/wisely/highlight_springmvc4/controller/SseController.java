package com.wisely.highlight_springmvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {

    @RequestMapping(value = "/push", produces = "text/event-stream") //1 服务器端SSE支持的媒体类型
    // 每5秒向浏览器推送随机消息
    public @ResponseBody String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
    }

}
