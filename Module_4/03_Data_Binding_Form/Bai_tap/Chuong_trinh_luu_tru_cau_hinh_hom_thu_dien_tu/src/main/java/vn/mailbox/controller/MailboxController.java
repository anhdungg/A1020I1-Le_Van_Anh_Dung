package vn.mailbox.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.mailbox.model.Mailbox;
import vn.mailbox.service.MailboxService;

@Controller
public class MailboxController {

    @Autowired
    private MailboxService mailboxService;

    @GetMapping(value = "/")
    public ModelAndView listMailbox(){
        return new ModelAndView("list", "mailboxList", mailboxService.findAll());
    }

    @GetMapping(value = "/create")
    public String viewCreate(Model model){
        model.addAttribute("mailbox", new Mailbox());
        return "create";
    }

    @PostMapping(value = "create")
    public String saveCreate(@ModelAttribute("mailbox") Mailbox mailbox){
        mailboxService.save(mailbox);
        return "redirect:/";
    }
}
