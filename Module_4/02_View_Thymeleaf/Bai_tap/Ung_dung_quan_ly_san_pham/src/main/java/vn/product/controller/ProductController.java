package vn.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.product.model.Product;
import vn.product.service.ProductService;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("listProduct", service.findAll());
//        model.addAttribute("statusCreate", null);
        return "/list";
    }

    @GetMapping(value = "/create")
    public String viewCreate(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String saveCreate(@Valid @ModelAttribute("product") Product product, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return "/create";
        }else {
            service.save(product);
            redirectAttributes.addFlashAttribute("statusCreate", "Create new product success");
            return "redirect:/";
        }
    }

    @GetMapping(value = "/edit")
    public String viewEdit(@RequestParam("id") int id, Model model){
        model.addAttribute("idSP", id);
        model.addAttribute("product", service.findById(id));
        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String saveEdit(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("idSP") int idSP, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return "/edit";
        }else {
            System.out.println(idSP);
            service.edit(idSP, product);
            redirectAttributes.addFlashAttribute("statusCreate", "Success");
            return "redirect:/";
        }
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("statusCreate", "Success");
        service.delete(id);
        return "redirect:/";
    }
}
