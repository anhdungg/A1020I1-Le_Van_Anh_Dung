package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.exception.NotAvailableBookException;
import vn.codegym.exception.NotFoundCodeBookException;
import vn.codegym.model.Book;
import vn.codegym.service.BookService;


@Controller
@SessionAttributes("user")
public class BookController {
    @Autowired
    private BookService service;

    @ModelAttribute("listStart")
    public int[] listStart(){
        return new int[5];
    }

    @GetMapping(value = "/library")
    public String home(Model model, @PageableDefault(12) Pageable pageable){
        Page<Book> page = service.findAll(pageable);
        model.addAttribute("listBook", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "book/index";
    }

    @GetMapping(value = "/library/{name}")
    public String view(Model model, @PathVariable String name){
        model.addAttribute("book", service.findByName(name));
        return "book/view";
    }

    @GetMapping(value = "/library/rent/{nameBook}")
    public String rent(RedirectAttributes redirectAttributes, @PathVariable String nameBook) throws NotAvailableBookException{
        int number = service.rentBook(nameBook);
        redirectAttributes.addFlashAttribute("codeBook", number);
        return "redirect:/library/" + nameBook;
    }

    @PostMapping(value = "/library/returnBook")
    public String returnBook(@RequestParam("codeBook") String codeBook, @RequestParam("nameBook") String nameBook,
                             RedirectAttributes redirectAttributes) throws NotFoundCodeBookException{
        service.returnBook(codeBook, nameBook);
        redirectAttributes.addFlashAttribute("message", "Trả sách thành công");
        return "redirect:/library/" + nameBook;
    }

    @ExceptionHandler(NotAvailableBookException.class)
    public String NotAvailableBook(Model model){
        model.addAttribute("message", "Lỗi. Sách này không còn trong thư viện");
        return "book/exception";
    }

    @ExceptionHandler(NotFoundCodeBookException.class)
    public String notFoundCodeBook(Model model){
        model.addAttribute("message", "Lỗi. Mã trả sách không đúng");
        return "book/exception";
    }
}
