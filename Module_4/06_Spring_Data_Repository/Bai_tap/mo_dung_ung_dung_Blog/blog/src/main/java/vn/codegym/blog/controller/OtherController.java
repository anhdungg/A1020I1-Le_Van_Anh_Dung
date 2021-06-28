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
public class OtherController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/tips")
    public String homeTips(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Mẹo vặt", pageable);
        model.addAttribute("tips", true);
        model.addAttribute("listPost", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "blog/index";
    }

    @GetMapping(value = "/tips/{title}")
    public String view(@PathVariable String title, Model model){
        model.addAttribute("tips", true);
        model.addAttribute("blog", blogService.findByURLTitle(title));
        return "blog/viewBlog";
    }

    @GetMapping(value = "/spring-boot")
    public String homeSpringBoot(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Spring Boot", pageable);
        model.addAttribute("springBoot", true);
        model.addAttribute("listPost", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "blog/index";
    }

    @GetMapping(value = "/spring-boot/{title}")
    public String viewSpringBoot(@PathVariable String title, Model model){
        model.addAttribute("springBoot", true);
        model.addAttribute("blog", blogService.findByURLTitle(title));
        return "blog/viewBlog";
    }

    @GetMapping(value = "/spring-core")
    public String homeSpringCore(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Spring Core", pageable);
        model.addAttribute("springCore", true);
        model.addAttribute("listPost", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "blog/index";
    }

    @GetMapping(value = "/spring-core/{title}")
    public String viewSpringCore(@PathVariable String title, Model model){
        model.addAttribute("springCore", true);
        model.addAttribute("blog", blogService.findByURLTitle(title));
        return "blog/viewBlog";
    }

    @GetMapping(value = "/java-core")
    public String homeJavaCore(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Java Core", pageable);
        model.addAttribute("javaCore", true);
        model.addAttribute("listPost", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "blog/index";
    }

    @GetMapping(value = "/java-core/{title}")
    public String viewJavaCore(@PathVariable String title, Model model){
        model.addAttribute("javaCore", true);
        model.addAttribute("blog", blogService.findByURLTitle(title));
        return "blog/viewBlog";
    }

    @GetMapping(value = "/mysql")
    public String homeMySql(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Java Core", pageable);
        model.addAttribute("mysql", true);
        model.addAttribute("listPost", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "blog/index";
    }

    @GetMapping(value = "/mysql/{title}")
    public String viewMySql(@PathVariable String title, Model model){
        model.addAttribute("mysql", true);
        model.addAttribute("blog", blogService.findByURLTitle(title));
        return "blog/viewBlog";
    }
}
