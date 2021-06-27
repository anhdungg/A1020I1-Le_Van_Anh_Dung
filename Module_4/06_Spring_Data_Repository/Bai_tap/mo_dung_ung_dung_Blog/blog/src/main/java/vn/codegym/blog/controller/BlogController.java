package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.repository.CategoryRepository;
import vn.codegym.blog.service.BlogService;
import vn.codegym.blog.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService service;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("listCategory")
    public List<Category> listCategory(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/")
    public String home(@PageableDefault(3) Pageable pageable, Model model){
        Page<Blog> page = service.findAll(pageable);
        model.addAttribute("listPost", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        model.addAttribute("home", true);
        return "blog/index";
    }

    @GetMapping(value = "/create-blog")
    public String viewCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping(value = "/create-blog")
    public String saveCreate(@Valid @ModelAttribute Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "blog/create";
        }else {
            redirectAttributes.addFlashAttribute("status", "Bài viết đã được lưu");
            service.save(blog);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/edit-blog/{id}")
    public ModelAndView viewEdit(@PathVariable Integer id){
        return new ModelAndView("blog/edit", "blog", service.findById(id));
    }

    @PostMapping(value = "/edit-blog")
    public String saveEdit(@Valid @ModelAttribute Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "blog/edit";
        }else {
            redirectAttributes.addFlashAttribute("status", "Bài viết đã được cập nhập");
            service.save(blog);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/delete-blog")
    public String delete(@RequestParam("id") Integer id, @RequestParam("location") String location, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("status", "Bài viết đã được xoá");
        service.delete(id);
        switch (location){
            case "mysql":
                return "redirect:/mysql";
            case "tips":
                return "redirect:/tips";
            default:
                return "redirect:/";
        }

    }

    @GetMapping(value = "/search")
    public ModelAndView viewSearch(@RequestParam("value") String value, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = service.findAllByTitleContaining(value, pageable);
        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("listPost", page);
        modelAndView.addObject("pages", new int[page.getTotalPages()]);
        return modelAndView;
    }

}
