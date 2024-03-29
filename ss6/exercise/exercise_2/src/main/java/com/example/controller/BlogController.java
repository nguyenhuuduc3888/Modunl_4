package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BlogController {

    @Autowired
    IBlogService blogService;

    //hien thi
    @GetMapping("/list")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/list","blog",blogService.findAll());
        return modelAndView;
    }

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
    public String update(@ModelAttribute("blog") Blog blog) {
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
