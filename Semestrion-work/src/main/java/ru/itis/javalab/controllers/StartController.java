package ru.itis.javalab.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

//    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
//    public String redirect() {
//        return "redirect:login";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "registration";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration() {
//        return "registration";
//    }

}
