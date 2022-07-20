package all.controller;

import all.model.Person;
import all.service.IPersonService;
import all.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    IPersonService personService = new PersonService();

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("person", personService.findALL());
        return "/list";
    }


    @GetMapping("/form")
    public String showFormCreate(Model model) {
        String[] dayOfBirth = personService.getDayOfBirth();
        String[] travel = personService.getTravel();
        String[] day = personService.getDay();
        model.addAttribute("dayOfBirth", dayOfBirth);
        model.addAttribute("travel", travel);
        model.addAttribute("day", day);
        model.addAttribute("person", new Person());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("person") Person person) {
        person.setId((int)(Math.random()*10000));
        personService.save(person);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String showFormEdit( int id, Model model) {
        Person person = personService.findById(id);
        String[] dayOfBirth = personService.getDayOfBirth();
        String[] travel = personService.getTravel();
        String[] day = personService.getDay();
        model.addAttribute("dayOfBirth", dayOfBirth);
        model.addAttribute("travel", travel);
        model.addAttribute("day", day);
        model.addAttribute("person", person);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Person person) {
        personService.update(person.getId(), person);
        return "redirect:/list";
    }
}
