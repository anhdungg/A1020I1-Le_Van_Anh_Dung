package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.*;
import vn.codegym.repository.DivisionRepository;
import vn.codegym.repository.EducationRepository;
import vn.codegym.repository.PositionRepository;
import vn.codegym.repository.RoleRepository;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.FuramaService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FuramaService furamaService;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private RoleRepository roleRepository;

    @ModelAttribute("listDivision")
    public List<Division> listDivision(){
        return divisionRepository.findAll();
    }

    @ModelAttribute("listPosition")
    public List<Position> listPosition(){
        return positionRepository.findAll();
    }

    @ModelAttribute("listEducation")
    public List<EducationDegree> listEducation(){
        return educationRepository.findAll();
    }

    @ModelAttribute("listRole")
    public List<Role> listRole(){
        return roleRepository.findAll();
    }

    @GetMapping(value = "/employee")
    public String viewEmployee(Model model, @PageableDefault(3) Pageable pageable,
                               @ModelAttribute("nameUser") String nameUser, @ModelAttribute("role") String role){
        if (nameUser.equals("") && role.equals("")){
            furamaService.getSession(nameUser, role, model);
        }
        Page<Employee> page = employeeService.findAll(pageable);
        model.addAttribute("selectNavbar", "employee");
        model.addAttribute("listEmployee", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "employee/list";
    }

    @GetMapping(value = "/employee/search")
    public String search(@RequestParam("key-word") String keyWord, @PageableDefault(5) Pageable pageable, Model model){
        Page<Employee> page = employeeService.findAllByName(keyWord, pageable);
        model.addAttribute("listEmployee", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        model.addAttribute("keyWord", keyWord);
        return "employee/list";
    }

    @PostMapping(value = "/employee/delete")
    public String deleteEmployee(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        Employee employee = this.employeeService.findById(id);
        if (employee != null) {
            this.employeeService.deleteById(id);
            redirectAttributes.addFlashAttribute("messageDelete", employee.getId());
        }
        return "redirect:/employee";
    }

    @GetMapping(value = "/employee/create")
    public String viewCreate(Model model){
        model.addAttribute("employee", new EmployeeRole());
        model.addAttribute("action", "create");
        return "employee/create";
    }

    @PostMapping(value = "/employee/create")
    public String saveCreate(Model model, @Valid @ModelAttribute EmployeeRole employeeRole, BindingResult bindingResult){
        model.addAttribute("action", "create");
        if (bindingResult.hasErrors()){
            model.addAttribute("employee", employeeRole);
            return "employee/create";
        }
        boolean checkExistEmail = employeeService.existsByEmail(employeeRole.getEmployee().getEmail());
        boolean checkAge = employeeService.checkAge(employeeRole.getEmployee().getDateOfBirth());
        if (checkExistEmail){
            model.addAttribute("errorEmail", "Email đã tồn tại");
        }
        if (checkAge){
            model.addAttribute("errorAge", "Phải lớn hơn 18 tuổi");
        }
//        employeeService.save(employeeRole);
        return "redirect:/employee";
    }
}
