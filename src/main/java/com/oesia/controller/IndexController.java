package com.oesia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    //@GetMapping("/")
    @GetMapping("/login")
    public String index() {
      //return "ajax";
        return "login";
    }

}