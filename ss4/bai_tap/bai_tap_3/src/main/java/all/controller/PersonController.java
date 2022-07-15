package all.controller;

import all.model.Person;
import all.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    IPersonService personService;

    @GetMapping("/form")
    public ModelAndView declareView() {
        ModelAndView modelAndView = new ModelAndView("form", "person", new Person());

        String[] dayOfBirth = personService.getDayOfBirth();
        String[] gender = personService.getGender();
        String[] country = personService.getCountry();
        String[] day = personService.getDay();
        String[] month = personService.getMonth();
        String[] year = personService.getYear();
        String[] travel = personService.getTravel();

        modelAndView.addObject("dayOfBirth", dayOfBirth);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("country", country);
        modelAndView.addObject("day", day);
        modelAndView.addObject("month", month);
        modelAndView.addObject("year", year);
        modelAndView.addObject("travel", travel);

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        return "result";
    }
}
