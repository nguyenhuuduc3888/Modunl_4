package all.controller;

import all.model.Product;
import all.service.IProductService;

import all.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Random;

@Controller
public class ProductController {
    IProductService productService = new ProductService();


    @GetMapping("/index")
    public String showList(Model model) {
        model.addAttribute("products", productService.finAll());
        model.addAttribute("product", new Product());
        return "/index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        product.setProductId((int) (Math.random() * 100));
        productService.save(product);
        return "redirect:index";
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam String description,
            @RequestParam String producer
    ) {
        Product product = new Product(id, name, price, description, producer);
        productService.update(product.getProductId(), product);
        return "redirect:index";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("success", "Delete successfully!");
        return "redirect:index";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> products = productService.findByName(name);
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "/index";
    }
}
