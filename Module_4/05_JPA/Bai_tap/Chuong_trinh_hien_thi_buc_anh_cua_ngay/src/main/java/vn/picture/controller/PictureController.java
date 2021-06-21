package vn.picture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.picture.model.Comment;
import vn.picture.model.Picture;
import vn.picture.repository.PictureRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PictureController {

    @Autowired
    private PictureRepository repository;

    @GetMapping(value = "/")
    public String home(Model model){
        Picture picture = repository.getPicture();
        model.addAttribute("like4", picture.getVote4star());
        model.addAttribute("like5", picture.getVote5star());
        model.addAttribute("listComment", this.getCommentOfDay(repository.getAllComment()));
//        this.getCommentOfDay(repository.getAllComment());
        return "index";
    }

    @GetMapping(value = "/vote5start")
    public String vote5(){
        repository.vote5star();
        return "redirect:/";
    }

    @GetMapping(value = "/vote4start")
    public String vote4(){
        repository.vote4star();
        return "redirect:/";
    }

    @PostMapping(value = "/comment")
    public String saveComment(@RequestParam("comment") String comment){
        repository.saveComment(comment);
        return "redirect:/";
    }

    private List<Comment> getCommentOfDay(List<Comment> comments){
        List<Comment> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        for (Comment comment : comments) {
            if (formatter.format(comment.getCommentDate()).equals(formatter.format(now))){
                list.add(comment);
            }
        }
        return list;
    }
}
