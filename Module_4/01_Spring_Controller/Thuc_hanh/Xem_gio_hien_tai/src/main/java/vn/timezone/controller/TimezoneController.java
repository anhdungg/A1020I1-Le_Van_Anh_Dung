package vn.timezone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimezoneController {
    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/timezone")
    public String timezone(@RequestParam("location") String location, Model model){
        // Get current time at local
        Date date = new Date();
        // Get timezone by the local
        TimeZone local = TimeZone.getDefault();
        // Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(location);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Reset the date by locale_time
        date.setTime(locale_time);
        model.addAttribute("city", location);
        model.addAttribute("date", date);
        return "index";
    }
}
