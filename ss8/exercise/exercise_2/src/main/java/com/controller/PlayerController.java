package com.controller;

import com.dto.PlayerDto;
import com.model.Player;
import com.service.IPlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PlayerController {
    @Autowired
    IPlayerService playerService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView =
                new ModelAndView("/list", "player", playerService.findAll(pageable));
        return modelAndView;
    }

    //Them moi
    @GetMapping("/create")
    public String showFormEdit(Model model) {
        model.addAttribute("playerDto", new PlayerDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("playerDto") PlayerDto playerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.save(player);
        return "redirect:list";
    }

    //Cap nhat
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        model.addAttribute("playerDto", playerService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("playerDto") PlayerDto playerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.update(player);
        return "redirect:list";
    }

    //Xoa
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        playerService.delete(id);
        return "redirect:list";
    }

}
