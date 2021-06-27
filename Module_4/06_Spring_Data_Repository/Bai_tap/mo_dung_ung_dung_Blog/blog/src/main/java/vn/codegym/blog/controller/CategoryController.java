package vn.codegym.blog.controller;

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
import vn.codegym.blog.model.Category;
import vn.codegym.blog.service.CategoryService;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/list-category")
    public ModelAndView viewAll(){
        ModelAndView modelAndView = new ModelAndView("category/listCategory");
        modelAndView.addObject("listCategory", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/create-category")
    public String viewCreate(Model model){
        model.addAttribute("category", new Category());
        return "category/createCategory";
    }

    @PostMapping(value = "/create-category")
    public String saveCreate(@ModelAttribute Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "category/createCategory";
        }else {
            redirectAttributes.addFlashAttribute("status", "Bài viết đã được lưu");
            categoryService.save(category);
            return "redirect:/list-category";
        }
    }

    @GetMapping(value = "/edit-category")
    public ModelAndView viewEdit(@RequestParam("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("category/editCategory");
        modelAndView.addObject("category", categoryService.findById(id));
//        System.out.println(categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "/edit-category")
    public String saveEdit(@Valid @ModelAttribute Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "category/editCategory";
        }else {
            redirectAttributes.addFlashAttribute("status", "Bài viết đã được cập nhập");
            categoryService.save(category);
            return "redirect:/list-category";
        }
    }

    @GetMapping(value = "/delete-category")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("status", "Bài viết đã được xoá");
        categoryService.delete(id);
        return "redirect:/list-category";
    }
}
