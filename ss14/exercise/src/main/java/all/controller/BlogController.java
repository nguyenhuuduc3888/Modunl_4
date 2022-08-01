package all.controller;

import all.model.Blog;
import all.model.Category;
import all.service.IBlogService;
import all.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    //hien thi
    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 4,
            sort = "day_create", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ModelAndView("/list", "blog", blogService.findAll(pageable));
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
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
        model.addAttribute("categoryList", categoryService.findAll());
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
