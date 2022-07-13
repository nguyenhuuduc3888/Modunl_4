package all.controller;

import all.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConvertController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/form")
    public String convert(@RequestParam double usd, double rate, Model model) {
        double vnd = convertService.convert(usd, rate);
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
