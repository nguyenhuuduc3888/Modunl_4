package all.controller;

import all.model.Player;
import all.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
    @Autowired
    IPlayerService playerService;

    @GetMapping("/a")
    public ModelAndView showList() {
        ModelAndView modelAndView =
                new ModelAndView("/list", "player", playerService.findAll());
        return modelAndView;
    }

    //Them moi
    @GetMapping("/create")
    public String showFormEdit(Model model) {
        model.addAttribute("player", new Player());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("player") Player player) {
        player.setId((int) (Math.random() * 1000));
        playerService.save(player);
        return "redirect:a";
    }

    //Xoa
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        playerService.delete(id);
        return "redirect:a";
    }

    //Cap nhat
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("player") Player player, Model model) {
        playerService.update(player);
        return "redirect:list";
    }

}
