package vn.user_model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.user_model.dao.UserDao;
import vn.user_model.model.Login;
import vn.user_model.model.User;

@Controller
public class UserController {
    @GetMapping(value = "/")
    public ModelAndView home(){
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDao.checkLogin(login);

        if(user == null){
            return new ModelAndView("error");
        } else {
            return new ModelAndView("user", "user", user);
        }
    }
}
