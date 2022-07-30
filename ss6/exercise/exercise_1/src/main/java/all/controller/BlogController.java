package all.controller;

import all.model.Blog;
import all.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BlogController {

    @Autowired
    IBlogService blogService;

    //hien thi
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("blog", blogService.findAll());
        return "/list";
    }

    //them moi
    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:list";
    }

    //xem chi tiet
    @GetMapping("/view")
    public String viewDetail(@RequestParam int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/viewDetail";
    }

    //sua
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.update(blog);
        return "redirect:list";
    }

    //xoa
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        blogService.delete(id);
        return "redirect:list";
    }
}
