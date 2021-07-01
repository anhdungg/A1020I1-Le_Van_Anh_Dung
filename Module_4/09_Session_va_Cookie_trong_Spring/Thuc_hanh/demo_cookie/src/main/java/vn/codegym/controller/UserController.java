package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String home(HttpServletRequest request, Model model){
        User user = new User();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("email")){
               user.setEmail(cookie.getValue());
            }
            if (cookie.getName().equals("password")){
                user.setPassword(cookie.getValue());
            }
        }
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping(value = "/login")
    public ModelAndView viewLogin(@CookieValue(name = "email", defaultValue = "") String email){
        return new ModelAndView("login", "user", new User(email));
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute User user, HttpServletResponse response){
        Cookie cookieEmail = new Cookie("email", user.getEmail());
        cookieEmail.setMaxAge(2 * 60);
        Cookie cookiePassword = new Cookie("password", user.getPassword());
        cookiePassword.setMaxAge(2 * 60);
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        return "redirect:/";
    }
}
