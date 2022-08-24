package all.controller;

import all.dto.EmployeeDto;
import all.model.employee.Employee;
import all.service.employee.IDivisionService;
import all.service.employee.IEducationDegreeService;
import all.service.employee.IEmployeeService;
import all.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IPositionService positionService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 3,sort = "name",direction = Sort.Direction.ASC)
                               Pageable pageable, Model model,
                           @RequestParam Optional<String> name) {
        model.addAttribute("position", positionService.finAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.finAll());
        model.addAttribute("employeeCreate", new Employee());
        model.addAttribute("name",name.orElse(""));
        model.addAttribute("employee", employeeService.findAll(pageable, name.orElse("")));
        return "employee/list";
    }

    //them moi
    @PostMapping("/save")
    public String save( Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }

    //Xoa
    @GetMapping("/delete")
    public String delete( int id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    //Cap nhat
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        model.addAttribute("position", positionService.finAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.finAll());
        model.addAttribute("employeeDto", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        model.addAttribute("position", positionService.finAll());
        model.addAttribute("division", divisionService.findAll());
        model.addAttribute("educationDegree", educationDegreeService.finAll());
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
