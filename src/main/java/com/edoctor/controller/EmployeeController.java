package com.edoctor.controller;

import com.edoctor.bean.APIKey;
import com.edoctor.bean.Employee;
import com.edoctor.bean.TestLazyInitBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/")
public class EmployeeController {


    @RequestMapping(value = "index", method = GET)
    public String showRegisterForm(Model model) {
        return "index";
    }

    @RequestMapping(value = "lazyTest", method = GET)
    public String lazyTest(Model model) {
        return "lazyTest";
    }

    @RequestMapping(value = "music", method = GET)
    public String music(Model model) {
        System.out.println("ahaha");
        return "music";
    }

    @RequestMapping(value="/register", method = POST)
    public String processRegistration(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            return "index";
        }
    }
}
