package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.dto.UserReg;
import ru.itis.javalab.services.SignUpService;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@Controller
public class RegController {


    @Autowired
    private SignUpService signUpService;

    @GetMapping("/success_signup")
    public String getSuccessPage() {
        return "success_signup";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userReg", new UserReg());
        return "registration";
    }

    @RequestMapping(value="/confirm/{code}", method=RequestMethod.GET)
    public String verificationToken(@PathVariable("code") String code){
        if (!signUpService.findFirstByConfirmCode(code).isPresent()) {
            return "registration";
        } else {
            signUpService.updateStatus(code);
            return "redirect:/start";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(@Valid UserReg user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            signUpService.signUp(user);
            return "redirect:/success_signup";
        } else {
            model.addAttribute("userReg", user);
            return "registration";
        }
    }
}
