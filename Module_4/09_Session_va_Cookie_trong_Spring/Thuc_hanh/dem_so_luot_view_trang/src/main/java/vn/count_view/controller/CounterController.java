package vn.count_view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.count_view.model.MyCounter;

@Controller
//@SessionAttributes("mycounter")
public class CounterController {

    @ModelAttribute("mycounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }

    @GetMapping(value = "/")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter){
        myCounter.increment();
        return "index";
    }
}
