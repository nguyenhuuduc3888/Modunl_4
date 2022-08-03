package all.controller;

import all.dto.CustomerDto;
import all.dto.FacilityDto;
import all.model.customer.Customer;
import all.model.facility.Facility;
import all.service.facility.IFacilityService;
import all.service.facility.IFacilityTypeService;
import all.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IRentTypeService rentTypeService;

    //display all nhớ thêm "%" + name +"%"
    @GetMapping("")
    public String findAll(@PageableDefault(value = 3) Pageable pageable, Model model,
                          @RequestParam Optional<String> name) {
        model.addAttribute("name", name.orElse(""));
        model.addAttribute("facilityList", facilityService.findAll(pageable, name.orElse("")));
        return "facility/list";
    }

    //them moi
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facilityDto", new Facility());
        model.addAttribute(("facilityType"), facilityTypeService.findAll());
        model.addAttribute(("rentType"), rentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, Model model) {
        model.addAttribute(("facilityType"), facilityTypeService.findAll());
        model.addAttribute(("rentType"), rentTypeService.findAll());
        if (bindingResult.hasErrors()) {
            return "facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return "redirect:/facility";
    }

    //Xoa
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        facilityService.delete(id);
        return "redirect:/facility";
    }

    //Cap nhat
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("facilityDto", facilityService.findById(id));
        model.addAttribute("rentType", rentTypeService.findAll());
        return "facility/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("facilityDto") FacilityDto facilityDto, BindingResult bindingResult, Model model) {
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        if (bindingResult.hasErrors()) {
            return "facility/edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.update(facility);
        return "redirect:/facility";
    }

}


