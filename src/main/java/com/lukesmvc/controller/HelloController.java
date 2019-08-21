package com.lukesmvc.controller;

import com.lukesmvc.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lyaegel on 08/20/2019
 */
@Controller
public class HelloController {
    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/hello")
    public String hello() {

        personService.printList();

        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2() {

        personService.printVersion();

        return "hello";
    }

}
