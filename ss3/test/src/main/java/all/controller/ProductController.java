package all.controller;

import all.model.Product;
import all.service.IProductService;
import all.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProductController {
    IProductService productService = new ProductService();

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList = productService.findByName(name);
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        Product products = productService.findById(id);
        model.addAttribute("products", products);
        return "/delete";
    }

    @PostMapping("/remove")
    public String delete(@ModelAttribute Product product) {
        productService.delete(product.getId());
        return "redirect:/index";
    }
}
