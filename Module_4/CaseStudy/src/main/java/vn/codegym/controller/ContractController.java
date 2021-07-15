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
import vn.codegym.model.*;
import vn.codegym.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("selectNavbar")
    public String selectNavBar(){
        return "contract";
    }

    @ModelAttribute("listEmployee")
    public List<Employee> listEmployee(){
        return employeeService.findAll();
    }

    @ModelAttribute("listCustomer")
    public List<Customer> listCustomer(){
        return customerService.findAll();
    }

    @ModelAttribute("listService")
    public List<Service> listService(){
        return serviceService.findAll();
    }

    @GetMapping(value = "/contract")
    public String viewContract(@PageableDefault(5) Pageable pageable, Model model){
        Page<Contract> page = contractService.findAll(pageable);
        model.addAttribute("listContract", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "contract/list";
    }

    @GetMapping(value = "/contract/search")
    public String search(@RequestParam("key-word") String keyWord, @PageableDefault(5) Pageable pageable, Model model){
        Page<Contract> page = contractService.search(pageable, keyWord);
        model.addAttribute("listContract", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        model.addAttribute("keyWord", keyWord);
        return "contract/list";
    }

    @PostMapping(value = "/contract/delete")
    public String deleteContract(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        Contract contract = this.contractService.findById(id);
        this.contractService.deleteById(id);

        redirectAttributes.addFlashAttribute("messageDelete", contract.getId());
        return "redirect:/contract";
    }

    @GetMapping(value = "/contract/create")
    public String viewCreate(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("action", "create");
        return "contract/create";
    }

    @PostMapping(value = "/contract/create")
    public String saveCreate(Model model, @Valid @ModelAttribute Contract contract, BindingResult bindingResult){
        model.addAttribute("action", "create");
        if (bindingResult.hasErrors()){
            model.addAttribute("contract", contract);
            return "contract/create";
        }
        contractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping(value = "/contract/edit/{id}")
    public String viewEdit(Model model, @PathVariable Integer id){
        Contract contract = this.contractService.findById(id);
        if (contract == null){
            return "redirect:/contract";
        }
        model.addAttribute("contract", contract);
        model.addAttribute("action", "edit");
        return "contract/create";
    }

    @PostMapping(value = "/contract/edit")
    public String saveEdit(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model){
        model.addAttribute("action", "edit");
        if (bindingResult.hasErrors()){
            model.addAttribute("service", contract);
            return "contract/create";
        }
        this.contractService.save(contract);
        return "redirect:/contract";
    }
}
