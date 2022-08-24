package all.controller;

import all.dto.CustomerDto;
import all.model.customer.Customer;
import all.service.customer.ICustomerService;
import all.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    //display all nhớ thêm "%" + name +"%"
    @GetMapping("")
    public String findAll(@PageableDefault(value = 3) Pageable pageable, Model model,
                          @RequestParam Optional<String> name) {
        model.addAttribute("name", name.orElse(""));
        model.addAttribute("customerList", customerService.findAll(pageable, name.orElse("")));
        return "customer/list";
    }

    //them moi
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute(("customerType"), customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, Model model) {
        model.addAttribute(("customerType"), customerTypeService.findAll());
        if (bindingResult.hasErrors()) {
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer";
    }

    //Xoa
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    //Cap nhat
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("customerList", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("customerList") CustomerDto customerDto, BindingResult bindingResult, Model model) {
        model.addAttribute("customerType", customerTypeService.findAll());
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.update(customer);
        return "redirect:/customer";
    }
}
