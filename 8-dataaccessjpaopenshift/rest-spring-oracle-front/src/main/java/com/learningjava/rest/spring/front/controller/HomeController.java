package com.learningjava.rest.spring.front.controller;

import com.learningjava.rest.spring.core.ReadDB;
import com.learningjava.rest.spring.core.Restaurantes;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("llego");
        ReadDB rd = new ReadDB();
        List<Restaurantes> data = rd.readRestaurantes("");
        model.addAttribute("restaurantes",data);
        return "index";
    }
}