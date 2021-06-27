package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.BlogService;

@Controller
public class SpringController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/spring-boot")
    public String homeSpringBoot(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Spring Boot", pageable);
        model.addAttribute("springBoot", true);
        model.addAttribute("listBlog", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "spring/index-spring";
    }

    @GetMapping(value = "/spring-boot/view/{id}")
    public String viewSpringBoot(@PathVariable Integer id, Model model){
        model.addAttribute("springBoot", true);
        model.addAttribute("blog", blogService.findById(id));
        return "spring/view-spring";
    }

    @GetMapping(value = "/spring-core")
    public String homeSpringCore(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Spring Core", pageable);
        model.addAttribute("springCore", true);
        model.addAttribute("listBlog", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "spring/index-spring";
    }

    @GetMapping(value = "/SpringCore/view/{id}")
    public String viewSpringCore(@PathVariable Integer id, Model model){
        model.addAttribute("springCore", true);
        model.addAttribute("blog", blogService.findById(id));
        return "spring/view-spring";
    }
}
