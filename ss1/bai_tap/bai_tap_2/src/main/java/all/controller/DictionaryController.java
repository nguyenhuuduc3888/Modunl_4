package all.controller;

import all.service.ITranslateService;
import com.sun.org.apache.bcel.internal.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    ITranslateService translateService;

    @GetMapping("/dictionary")
    public String showForm() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public String translate(@RequestParam String english, Model model) {
        String vietnamese = translateService.translate(english);
        model.addAttribute("vietnamese", vietnamese);
        model.addAttribute("english", english);
        return "dictionary";
    }
}
