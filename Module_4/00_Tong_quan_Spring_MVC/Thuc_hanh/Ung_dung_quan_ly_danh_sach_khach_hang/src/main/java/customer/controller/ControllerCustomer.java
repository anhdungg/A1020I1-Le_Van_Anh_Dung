package customer.controller;

import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerCustomer {
    private CustomerService service = new CustomerServiceImpl();
    @GetMapping("/customer")
    public String getList(Model model){
        model.addAttribute("listCustomer", this.service.findAll());
        return "index";
    }

    @GetMapping("/customer/view")
    public String viewCustomer(@RequestParam("id") int id, Model model){
        model.addAttribute("customer", this.service.findById(id));
        return "view";
    }
}
