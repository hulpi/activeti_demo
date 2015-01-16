package me.kafeitu.demo.activiti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录页面
 *
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
