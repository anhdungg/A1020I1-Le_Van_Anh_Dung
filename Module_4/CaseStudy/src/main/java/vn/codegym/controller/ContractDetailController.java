package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.AttachService;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.AttachServiceRepository;
import vn.codegym.service.ContractDetailService;
import vn.codegym.service.ContractService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @ModelAttribute("selectNavbar")
    public String selectNavBar(){
        return "contract-detail";
    }

    @ModelAttribute("listContract")
    public List<Contract> listContract(){
        return contractService.findAll();
    }

    @ModelAttribute("listAttachService")
    public List<AttachService> listAttachService(){
        return attachServiceRepository.findAll();
    }

    @GetMapping(value = "/contract-detail")
    public String viewContractDetail(@PageableDefault(5) Pageable pageable, Model model){
        Page<ContractDetail> page = contractDetailService.findAll(pageable);
        model.addAttribute("listContractDetail", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        return "contract_detail/list";
    }

    @GetMapping(value = "/contract-detail/search")
    public String viewSearch(@RequestParam("key-word") String keyWord, @PageableDefault(5) Pageable pageable, Model model){
        Page<ContractDetail> page = contractDetailService.findAllByAttachService_NameContaining(pageable, keyWord);
        model.addAttribute("listContractDetail", page);
        model.addAttribute("page", new int[page.getTotalPages()]);
        model.addAttribute("keyWord", keyWord);
        return "contract_detail/list";
    }

    @PostMapping(value = "/contract-detail/delete")
    public String deleteContractDetail(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        ContractDetail contractDetail = this.contractDetailService.findById(id);
        this.contractDetailService.deleteById(id);

        redirectAttributes.addFlashAttribute("messageDelete", contractDetail.getId());
        return "redirect:/contract-detail";
    }

    @GetMapping(value = "/contract-detail/create")
    public String viewCreate(Model model){
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("action", "create");
        return "contract_detail/create";
    }

    @PostMapping(value = "/contract-detail/create")
    public String saveCreate(Model model, @Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult){
        model.addAttribute("action", "create");
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDetail", contractDetail);
            return "contract_detail/create";
        }
        contractDetailService.save(contractDetail);
        return "redirect:/contract-detail";
    }

    @GetMapping(value = "/contract-detail/edit/{id}")
    public String viewEdit(Model model, @PathVariable Integer id){
        ContractDetail contractDetail = this.contractDetailService.findById(id);
        if (contractDetail == null){
            return "redirect:/contract-detail";
        }
        model.addAttribute("contractDetail", contractDetail);
        model.addAttribute("action", "edit");
        return "contract_detail/create";
    }

    @PostMapping(value = "/contract-detail/edit")
    public String saveEdit(@Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult, Model model){
        model.addAttribute("action", "edit");
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDetail", contractDetail);
            return "contract_detail/create";
        }
        this.contractDetailService.save(contractDetail);
        return "redirect:/contract-detail";
    }
}
