package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.javalab.dto.UserReg;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignPage(Model model) {
        model.addAttribute("userReg", new UserReg());
        return "signIn";
    }
}
