package all.controller;

import all.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @GetMapping("/showForm")
    public String show(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        modelMap.addAttribute("id", employee.getId());
        return "info";
    }
}
