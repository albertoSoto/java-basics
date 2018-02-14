package com.learningjava.full.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
@Controller
public class HomeController {

    @RequestMapping(value={"/", "/home"})
    public String index(Model model) {
        System.out.println("home!");
        return "home";
    }

    @RequestMapping("/hello")
    public String hi(Model model) {
        System.out.println("hi!");
        return "hello";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        System.out.println("login!");
        return "login";
    }

}