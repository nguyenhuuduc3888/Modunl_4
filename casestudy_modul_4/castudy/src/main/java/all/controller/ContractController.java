package all.controller;

import all.dto.ContractDto;
import all.dto.CustomerDto;
import all.model.contract.Contract;
import all.model.customer.Customer;
import all.service.contract.IAttachFacilityService;
import all.service.contract.IContractDetailService;
import all.service.contract.IContractService;
import all.service.customer.ICustomerService;
import all.service.employee.IEmployeeService;
import all.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachFacilityService attachFacilityService;
    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IFacilityService facilityService;
    @Autowired
    ICustomerService customerService;

    //nhớ thêm % %
    @GetMapping("")
    public String findAll(@PageableDefault(value = 3) Pageable pageable, Model model,
                          @RequestParam Optional<String> name) {
        model.addAttribute("name", name.orElse(""));
        model.addAttribute("contractDetail", contractDetailService.findAll());
        model.addAttribute("attachFacility", attachFacilityService.findALL());
        model.addAttribute("contractList", contractService.findAll(pageable, name.orElse("")));
        return "contract/list";
    }


    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("contractDto", new Contract());
        model.addAttribute(("employeeService"), employeeService.find());
        model.addAttribute(("facilityService"), facilityService.find());
        model.addAttribute(("customerService"), customerService.find());
        return "contract/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult, Model model) {
        model.addAttribute(("employeeService"), employeeService.find());
        model.addAttribute(("facilityService"), facilityService.find());
        model.addAttribute(("customerService"), customerService.find());
        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        return "redirect:/contract";
    }
}
