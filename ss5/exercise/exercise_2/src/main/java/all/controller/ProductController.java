package all.controller;

import all.model.Product;
import all.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView =
                new ModelAndView("/list", "product", productService.findAll());
        return modelAndView;
    }

    //Them moi
    @GetMapping("/create")
    public String showFormEdit(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        return "redirect:list";
    }

    //Xoa
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:list";
    }

    //Cap nhat
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, Model model) {
        productService.update(product);
        return "redirect:list";
    }

}
