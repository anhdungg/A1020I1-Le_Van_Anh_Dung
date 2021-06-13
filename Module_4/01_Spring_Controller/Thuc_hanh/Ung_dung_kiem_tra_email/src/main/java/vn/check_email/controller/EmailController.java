package vn.check_email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @PostMapping(value = "/validate")
    public String home(@RequestParam("email") String email, Model model){
        if (email.matches(EMAIL_REGEX)){
            model.addAttribute("status", "Success");
        }else {
            model.addAttribute("status", "Fail");
        }
        model.addAttribute("email", email);
        return "index";
    }
}
