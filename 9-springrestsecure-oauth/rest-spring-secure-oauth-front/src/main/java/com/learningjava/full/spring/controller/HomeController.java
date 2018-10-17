package com.learningjava.full.spring.controller;

import com.learningjava.full.spring.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.debug("Getting home page");
        return "home";
    }

}
