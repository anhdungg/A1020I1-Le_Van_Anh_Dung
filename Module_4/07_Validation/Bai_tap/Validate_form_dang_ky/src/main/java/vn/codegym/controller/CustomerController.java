package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    CustomerRepository repository;

    @GetMapping(value = "/")
    public ModelAndView home(){
        return new ModelAndView("index", "listCustomer", repository.findAll());
    }

    @GetMapping(value = "/create")
    public ModelAndView viewCreate(){
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping(value = "/create")
    public String saveCreate(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }else {
            redirectAttributes.addFlashAttribute("message", "Create success");
            repository.save(customer);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String viewEdit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", repository.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String saveEdit(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "edit";
        }else {
            redirectAttributes.addFlashAttribute("message", "Update success");
            repository.save(customer);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String viewDelete(@PathVariable Integer id, Model model){
        model.addAttribute("customer", repository.findById(id).orElse(null));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String saveDelete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/";
    }
}
