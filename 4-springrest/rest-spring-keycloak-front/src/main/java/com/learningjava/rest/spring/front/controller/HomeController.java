package com.learningjava.rest.spring.front.controller;

import com.learningjava.rest.spring.core.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        String name = "Pepito";
        List<Greeting> arrData = new ArrayList<>();
        for (int i=0;i<9;i++){
            arrData.add(new Greeting(i,String.format("John Doe%s", i)));
        }
        //List<Restaurants> arrData2 = ReadDB.getAll();
        model.addAttribute("name",name);
        model.addAttribute("list",arrData);
        //model.addAttribute("restaurantes",ReadDB.getAll());
        //model.addAttribute("db",ReadDB);
        return "index";
    }
}