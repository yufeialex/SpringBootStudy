package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //1 声明一个控制器建言，组合了@Component注解，会注册成Bean
public class ExceptionHandlerAdvice {

    //2 注解定义全局的处理，value属性过滤拦截的Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");// error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    //3 本来作用是绑定键值对到Model里，此处是将键值对添加到全局，所有注解了@RequestMapping的方法都可以获得此键值对
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    //4 用来设置WebDataBinder，它是用来自动绑定前台请求参数到Model中
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //5 忽略request参数的id
        webDataBinder.setDisallowedFields("id");
    }
}
