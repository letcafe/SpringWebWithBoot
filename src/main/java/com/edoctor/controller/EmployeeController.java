package com.edoctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @RequestMapping(value = "lazyTest", method = GET)
    public String lazyTest(Model model) {
        return "lazyTest";
    }

    @RequestMapping(value = "websock", method = GET)
    public String webSock(Model model) {
        return "websock";
    }

    @RequestMapping(value="index", method = GET)
    public String index() {
        return "websock";
    }

    @RequestMapping(value="login", method = GET)
    public String login() {
        return "login";
    }
}
