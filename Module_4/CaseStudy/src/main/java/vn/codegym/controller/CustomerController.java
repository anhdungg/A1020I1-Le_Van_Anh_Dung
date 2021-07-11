package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;
import vn.codegym.service.FuramaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Controller
@SessionAttributes({"nameUser", "role"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FuramaService furamaService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("nameUser")
    public String nameUser(){
        return "";
    }

    @ModelAttribute("role")
    public String role(){
        return "";
    }

    @ModelAttribute("selectNavbar")
    public String selectNavBar(){
        return "customer";
    }

    @GetMapping(value = "/customer")
    public String viewEmployee(Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute("nameUser") String nameUser,
                               @ModelAttribute("role") String role, HttpServletRequest request){
        if (nameUser.equals("") && role.equals("")){
            furamaService.getSession(nameUser, role, model);
        }
        Page<Customer> page = customerService.findAll(pageable);
        model.addAttribute("listCustomer", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "customer/list";
    }

    @GetMapping(value = "/customer/create")
    public String viewCreate(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomerType", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String saveCreate(@ModelAttribute Customer customer, @RequestParam("dayOfBirth") String dayOfBirth){
        customer.setDateOfBirth(LocalDate.parse(dayOfBirth));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @PostMapping(value = "/customer/delete")
    public String deleteCustomer(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        Customer customer = customerService.findById(id);
        customerService.deleteById(id);

        redirectAttributes.addFlashAttribute("messageDelete", customer.getName());
        return "redirect:/customer";
    }

    @GetMapping(value = "/customer/search")
    public String search(@RequestParam("key-word") String keyWord, @PageableDefault(5) Pageable pageable, Model model){
        Page<Customer> page = customerService.findAllByNameContaining(keyWord, pageable);
        model.addAttribute("listCustomer", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        model.addAttribute("keyWord", keyWord);
        return "customer/list";
    }
}
