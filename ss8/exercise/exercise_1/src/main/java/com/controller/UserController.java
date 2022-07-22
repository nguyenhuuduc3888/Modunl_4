package com.controller;

import com.dto.UserDto;
import com.model.User;
import com.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String user(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "redirect:list";
    }
}
