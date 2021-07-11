package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.Employee;
import vn.codegym.model.Role;
import vn.codegym.model.User;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.FuramaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private FuramaService furamaService;

    @GetMapping(value = "/employee")
    public String viewEmployee(Model model, @PageableDefault(3) Pageable pageable,
                               @ModelAttribute("nameUser") String nameUser, @ModelAttribute("role") String role){
        if (nameUser.equals("") && role.equals("")){
            furamaService.getSession(nameUser, role, model);
        }
        Page<Employee> page = service.findAll(pageable);
        model.addAttribute("selectNavbar", "employee");
        model.addAttribute("listEmployee", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "employee/list";
    }


}
