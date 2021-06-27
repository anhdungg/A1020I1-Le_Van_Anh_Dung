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
public class TipsController {

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "/tips")
    public String homeTips(Model model, @PageableDefault(3) Pageable pageable){
        Page<Blog> page = blogService.findAllByCategory_Name("Mẹo vặt", pageable);
        model.addAttribute("tips", true);
        model.addAttribute("listTips", page);
        model.addAttribute("pages", new int[page.getTotalPages()]);
        return "tips/index-tips";
    }

    @GetMapping(value = "/tips/view/{id}")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("tips", true);
        model.addAttribute("blog", blogService.findById(id));
        return "tips/view-tips";
    }

}
