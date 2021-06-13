package vn.computer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/calculator")
    public String calculator(@RequestParam String number1, @RequestParam String number2, @RequestParam String calculation, Model model){
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", this.calculation(number1, number2, calculation));
        return "index";
    }

    private String calculation(String number1, String number2, String calculation){
        try {
            double result = 0;
            switch (calculation){
                case "+":
                    result = Double.parseDouble(number1) + Double.parseDouble(number2);
                    break;
                case "-":
                    result = Double.parseDouble(number1) - Double.parseDouble(number2);
                    break;
                case "*":
                    result = Double.parseDouble(number1) * Double.parseDouble(number2);
                    break;
                case "/":
                    if (Double.parseDouble(number2) == 0){
                        return "Cannot divide by zero";
                    }
                    result = Double.parseDouble(number1) / Double.parseDouble(number2);
                    break;
            }
            return result+"";
        }catch (NumberFormatException ex){
            return "0";
        }
    }
}
