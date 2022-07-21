package all.controller;

import all.model.Blog;
import all.model.Category;
import all.service.IBlogService;
import all.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    //hien thi
    @GetMapping("/listcategory")
    public ModelAndView showList() {
        return new ModelAndView("/listCategory", "categoryList", categoryService.findAll());
    }

    //them moi
    @GetMapping("/createcategory")
    private String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/createCategory";
    }

    @PostMapping("/savecategory")
    public String save(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:listcategory";
    }


    //sua
    @GetMapping("/updatecategory")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/editCategory";
    }

    @PostMapping("/editcategory")
    public String update(@ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:listcategory";
    }

    //xoa
    @GetMapping("/deletecategory")
    public String delete(@RequestParam int id) {
        categoryService.delete(id);
        return "redirect:listcategory";
    }

}
