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
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.BlogService;

import javax.validation.Valid;

@Controller
public class BlogController {
    @Autowired
    private BlogService service;

    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("listPost", service.findAll());
        return "index";
    }

    @GetMapping(value = "/create")
    public String viewCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String saveCreate(@Valid @ModelAttribute Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }else {
            redirectAttributes.addFlashAttribute("status", "Bài viết đã được lưu");
            service.save(blog);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/edit")
    public ModelAndView viewEdit(@RequestParam("id") Integer id){
        return new ModelAndView("edit", "blog", service.findById(id));
    }

    @PostMapping(value = "/edit")
    public String saveEdit(@Valid @ModelAttribute Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "edit";
        }else {
            redirectAttributes.addFlashAttribute("status", "Bài viết đã được cập nhập");
            service.save(blog);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("status", "Bài viết đã được xoá");
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/view")
    public String view(@RequestParam("id") Integer id, Model model){
        model.addAttribute("blog", service.findById(id));
        return "viewBlog";
    }
}
