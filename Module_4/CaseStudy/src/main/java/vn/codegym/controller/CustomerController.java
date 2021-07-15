package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.model.CustomerType;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;
import vn.codegym.service.FuramaService;
import javax.validation.Valid;
import java.util.List;

@Controller
//@SessionAttributes({"nameUser", "role"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @ModelAttribute("nameUser")
//    public String nameUser(){
//        return "";
//    }
//
//    @ModelAttribute("role")
//    public String role(){
//        return "";
//    }

    @ModelAttribute("selectNavbar")
    public String selectNavBar(){
        return "customer";
    }

    @ModelAttribute("listCustomerType")
    public List<CustomerType> listCustomerType(){
        return customerTypeService.findAll();
    }

    @GetMapping(value = "/customer")
    public String viewEmployee(Model model, @PageableDefault(5) Pageable pageable
//            , @ModelAttribute("nameUser") String nameUser, @ModelAttribute("role") String role){
    ){
//        if (nameUser.equals("") && role.equals("")){
//            furamaService.getSession(nameUser, role, model);
//        }
        Page<Customer> page = customerService.findAll(pageable);
        model.addAttribute("listCustomer", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "customer/list";
    }

    @GetMapping(value = "/customer/create")
    public String viewCreate(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String saveCreate(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customer", customer);
            return "customer/create";
        }
        if (customerService.existsById(customer.getId())){
            model.addAttribute("customer", customer);
            model.addAttribute("duplicateId", "ID đã tồn tại");
            return "customer/create";
        }
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping(value = "/customer/edit/{id}")
    public String viewEdit(Model model, @PathVariable String id){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return "redirect:/customer";
        }
        model.addAttribute("idOriginal", customer.getId());
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping(value = "/customer/edit")
    public String saveEdit(@Valid @ModelAttribute Customer customer, BindingResult bindingResult,
                           @RequestParam("idOriginal") String idOriginal, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customer", customer);
            model.addAttribute("idOriginal", idOriginal);
            return "customer/edit";
        }
        if (customer.getId().equals(idOriginal)){
            customerService.save(customer);
        }else {
            if (customerService.existsById(customer.getId())){
                model.addAttribute("customer", customer);
                model.addAttribute("idOriginal", idOriginal);
                model.addAttribute("duplicateId", "ID đã tồn tại");
                return "customer/edit";
            }
            customerService.updateById(customer.getId(), idOriginal);
        }

        return "redirect:/customer";
    }

    @PostMapping(value = "/customer/delete")
    public String deleteCustomer(@RequestParam("id") String id, RedirectAttributes redirectAttributes){
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
