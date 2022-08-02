package all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/loginBlog")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }
}
