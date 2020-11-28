package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    //ログイン画面への遷移
    @GetMapping
    public String getLogin() {
        return "login";
    }

    //ログイン成功時のメニュー画面への遷移
    @PostMapping
    public String postLogin() {
        return "redirect:/home";
    }
}