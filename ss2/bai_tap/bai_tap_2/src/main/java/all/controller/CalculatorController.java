package all.controller;

import all.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String show() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double num1, double num2, String operator, Model model) {
        String err = "";
        if (num2 == 0 && operator.equals("/")) {
            err = "khong chia cho 0";
        }
        double result = calculatorService.calculate(num1, num2, operator);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        model.addAttribute("err", err);
        return "calculator";
    }
}
