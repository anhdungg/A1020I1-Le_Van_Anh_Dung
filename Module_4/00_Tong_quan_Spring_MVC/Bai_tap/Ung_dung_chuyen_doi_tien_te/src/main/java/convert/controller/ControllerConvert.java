package convert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerConvert {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("input") String input, Model model){
        if (input == null){
            model.addAttribute("output", "0");
        }else {
            try {
                double output = Integer.parseInt(input) * 23000;
                model.addAttribute("output", output);
            }catch (NumberFormatException e){
                model.addAttribute("output", "0");
            }
        }
        model.addAttribute("input", input);
        return "index";
    }
}
