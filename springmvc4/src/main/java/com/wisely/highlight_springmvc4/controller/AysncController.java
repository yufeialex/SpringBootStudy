package com.wisely.highlight_springmvc4.controller;

import com.wisely.highlight_springmvc4.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
//1 异步任务的实现是通过控制器从另外一个线程返回一个DeferredResult
public class AysncController {
    // 定时任务，定时更新DeferredResult
    @Autowired
    PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() { //2
        return pushService.getAsyncUpdate();
    }

}

