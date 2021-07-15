package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.model.ServiceType;
import vn.codegym.repository.RentTypeRepository;
import vn.codegym.repository.ServiceTypeRepository;
import vn.codegym.service.ServiceService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService service;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    
    @ModelAttribute("selectNavbar")
    public String selectNavBar(){
        return "service";
    }

    @ModelAttribute("listRentType")
    public List<RentType> listRentType(){
        return rentTypeRepository.findAll();
    }

    @ModelAttribute("listServiceType")
    public List<ServiceType> listServiceType(){
        return serviceTypeRepository.findAll();
    }

    @GetMapping(value = "/service")
    public String viewService(@PageableDefault(5) Pageable pageable, Model model){
        Page<Service> page = service.findAll(pageable);
        model.addAttribute("listService", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "service/list";
    }

    @GetMapping(value = "/service/search")
    public String search(@RequestParam("key-word") String keyWord, @PageableDefault(5) Pageable pageable, Model model){
        Page<Service> page = service.findAllByNameContaining(keyWord, pageable);
        model.addAttribute("listService", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        model.addAttribute("keyWord", keyWord);
        return "service/list";
    }

    @PostMapping(value = "/service/delete")
    public String deleteService(@RequestParam("id") String id, RedirectAttributes redirectAttributes){
        Service service = this.service.findById(id);
        this.service.deleteById(id);

        redirectAttributes.addFlashAttribute("messageDelete", service.getName());
        return "redirect:/service";
    }

    @GetMapping(value = "/service/create")
    public ModelAndView viewCreate(){
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("action", "create");
        return modelAndView;
    }

    @PostMapping(value = "/service/create")
    public String saveCreate(Model model, @Valid @ModelAttribute Service service, BindingResult bindingResult){
        model.addAttribute("action", "create");
        if (bindingResult.hasErrors()){
            model.addAttribute("service", service);
            return "service/create";
        }
        if (this.service.existsById(service.getId())){
            model.addAttribute("service", service);
            model.addAttribute("duplicateId", "ID đã tồn tại");
            return "service/create";
        }
        this.service.save(service);
        return "redirect:/service";
    }

    @GetMapping(value = "/service/edit/{id}")
    public String viewEdit(Model model, @PathVariable String id){
        Service service = this.service.findById(id);
        if (service == null){
            return "redirect:/service";
        }
        model.addAttribute("service", service);
        model.addAttribute("idOriginal", service.getId());
        model.addAttribute("action", "edit");
        return "service/create";
    }

    @PostMapping(value = "/service/edit")
    public String saveEdit(@Valid @ModelAttribute Service service, BindingResult bindingResult,
                           @RequestParam("idOriginal") String idOriginal, Model model){
        model.addAttribute("action", "edit");
        if (bindingResult.hasErrors()){
            model.addAttribute("service", service);
            model.addAttribute("idOriginal", idOriginal);
            return "service/create";
        }
//        if (this.service.existsById(service.getId())){
//            model.addAttribute("service", service);
//            model.addAttribute("idOriginal", idOriginal);
//            model.addAttribute("duplicateId", "ID đã tồn tại");
//            return "service/create";
//        }
        this.service.update(service, idOriginal);

        return "redirect:/service";
    }
}
