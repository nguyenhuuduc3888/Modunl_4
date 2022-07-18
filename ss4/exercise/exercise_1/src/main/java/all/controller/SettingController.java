package all.controller;

import all.model.MailBox;
import all.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @Autowired
    ISettingService settingService;

    @GetMapping("/form")
    public ModelAndView setting() {
        ModelAndView modelAndView = new ModelAndView("setting", "mailbox", new MailBox());
        String[] listLanguages = settingService.getLanguages();
        int[] listPageSize = settingService.getPageSize();
        modelAndView.addObject("listLanguages", listLanguages);
        modelAndView.addObject("listPageSize", listPageSize);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("mailbox") MailBox mailBox) {
        ModelAndView modelAndView = new ModelAndView("update");
        String[] listLanguages = settingService.getLanguages();
        int[] listPageSize = settingService.getPageSize();
        modelAndView.addObject("listLanguages", listLanguages);
        modelAndView.addObject("listPageSize", listPageSize);
        return modelAndView;
    }
}
