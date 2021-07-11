package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.User;
import vn.codegym.service.FuramaService;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes({"nameUser", "role"})
public class FuramaController {

    @ModelAttribute("nameUser")
    public String nameUser(){
        return "";
    }

    @ModelAttribute("role")
    public String role(){
        return "";
    }

    @Autowired
    private FuramaService furamaService;

    @GetMapping(value = "/")
    public String home(Model model, @ModelAttribute("nameUser") String nameUser, @ModelAttribute("role") String role){
        if (nameUser.equals("") && role.equals("")){
            furamaService.getSession(nameUser, role, model);
        }
        model.addAttribute("selectNavbar", "home");
        return "index";
    }

    @GetMapping(value = "/login")
    public String viewLogin(){
        return "login_error/login";
    }

    @GetMapping(value = "/loginFail")
    public String errorLogin(Model model){
        model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
        return "login_error/login";
    }

    @GetMapping(value = "/403")
    public String error403(){
        return "login_error/error_403";
    }
}
