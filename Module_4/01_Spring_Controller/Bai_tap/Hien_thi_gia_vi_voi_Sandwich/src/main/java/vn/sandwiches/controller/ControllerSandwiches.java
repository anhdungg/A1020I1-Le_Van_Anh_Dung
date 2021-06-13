package vn.sandwiches.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ControllerSandwiches {
    @GetMapping(value = "/")
    public String seasoning(){
        return "index";
    }

    @GetMapping(value = "/save")
    public String eating(HttpServletRequest request, Model model) throws ServletException {
        String lettuce = request.getParameter("lettuce");
        String tomato = request.getParameter("tomato");
        String mustard = request.getParameter("mustard");
        String sprouts = request.getParameter("sprouts");
        StringBuilder str = new StringBuilder();
        if (lettuce != null){
            str.append("Lettuce, ");
        }
        if (tomato != null){
            str.append("Tomato, ");
        }
        if (mustard != null){
            str.append("Mustard, ");
        }
        if (sprouts != null){
            str.append("Sprouts, ");
        }
        if (str.toString().equals("")){
            str = new StringBuilder("Empty");
            model.addAttribute("seasoning", str);
        }else {
            model.addAttribute("seasoning", str.substring(0, str.length() - 2));
        }
        return "eat";
    }
}
