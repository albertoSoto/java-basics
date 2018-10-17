package com.learningjava.full.spring.controller;

import com.learningjava.full.spring.dao.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
/**
 * com.learningjava.full.spring.controller
 * Class
 * By berto. 12/02/2018
 */
@RestController
@RequestMapping(path = RestApiController.REST_API_MAPPING)
public class RestApiController {
    public static final String REST_API_MAPPING = "/rest/api/v1";
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting",method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
