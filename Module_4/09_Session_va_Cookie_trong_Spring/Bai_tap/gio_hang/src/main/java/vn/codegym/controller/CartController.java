package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Product;
import vn.codegym.repository.CartRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartRepository repository;

    @GetMapping(value = "/")
    public String home(HttpServletRequest request, Model model){
        model.addAttribute("listProduct", repository.findAll());
        model.addAttribute("listRecommend", this.getRecommend(request));
        model.addAttribute("listCart", this.getListProduct(request));
        return "index";
    }

    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable int id, HttpServletResponse response, @CookieValue(name = "countRecommend", defaultValue = "0") String count){
        if (count.equals("4")){
            count = "0";
        }
        Cookie cookie = new Cookie("countRecommend", ""+(Integer.parseInt(count)+1));
        cookie.setMaxAge(5 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new Cookie("recommend"+(Integer.parseInt(count)+1), ""+id);
        cookie.setMaxAge(5 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/views/" + id;
    }

    @GetMapping(value = "/views/{id}")
    public String views(@PathVariable int id, Model model, HttpServletRequest request){
        model.addAttribute("listCart", this.getListProduct(request));
        model.addAttribute("product", repository.findById(id));
        model.addAttribute("listRecommend", this.getRecommend(request));
        return "view";
    }

    @GetMapping(value = "/addcart/{id}")
    public String addCart(@PathVariable int id, HttpServletResponse response){
        Product product = repository.findById(id);
        product.setSoLuong(1);
        Cookie cookie = new Cookie("cart"+id, ""+id);
        cookie.setMaxAge(5 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping(value = "/cart")
    public String viewCart(Model model, HttpServletRequest request){
        List<Product> list = this.getListProduct(request);
        long total=0;
        for (Product product : list){
            total+=(product.getGia()*product.getSoLuong());
        }
        model.addAttribute("listCart", list);
        model.addAttribute("listRecommend", this.getRecommend(request));
        model.addAttribute("totalMoney", total);
        model.addAttribute("finallyMoney", total+20);
        return "cart";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable String id, HttpServletResponse response){
        Cookie cookie = new Cookie("cart"+id, id);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/cart";
    }

    @GetMapping(value = "/deleteAll")
    public String deleteAll(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie ck : cookies){
            if (ck.getName().contains("cart")){
                Cookie cookie = new Cookie(ck.getName(), ck.getValue());
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "redirect:/";
    }

    @GetMapping(value = "/changeSL/{id}/{sl}")
    public String change(@PathVariable int id, @PathVariable int sl){
        Product product = repository.findById(id);
        product.setSoLuong(sl);
        return "redirect:/cart";
    }

    private List<Product> getRecommend(HttpServletRequest request){
        List<Product> list = new ArrayList<>();
        Cookie[] listCookie = request.getCookies();
        for (Cookie cookie : listCookie){
            if (cookie.getName().contains("recommend")){
                int id = Integer.parseInt(cookie.getValue());
                list.add(repository.findById(id));
            }
        }
        return list;
    }

    private List<Product> getListProduct(HttpServletRequest request){
        List<Product> list = new ArrayList<>();
        Cookie[] listCookie = request.getCookies();
        for (Cookie cookie : listCookie){
            if (cookie.getName().contains("cart")){
                int id = Integer.parseInt(cookie.getValue());
                list.add(repository.findById(id));
            }
        }
        return list;
    }

}
