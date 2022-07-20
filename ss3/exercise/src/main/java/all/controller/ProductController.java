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

//    @GetMapping("/index")
//    public String index(Model model) {
//        List<Product> productList = productService.finAll();
//        model.addAttribute("products", productList);
//        return "/index";
//    }
//
//    @GetMapping("/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("product", new Product());
//        return "/create";
//    }
//
//    @PostMapping("/save")
//    public String save(Product product, RedirectAttributes redirectAttributes) {
//        product.setProductId((int) (Math.random() * 1000));
//        productService.save(product);
//        redirectAttributes.addFlashAttribute("success", "Them moi ok!");
//        return "redirect:/index";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String showFormEdit(@PathVariable int id, Model model) {
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "/edit";
//    }
//
//    @PostMapping("/edit")
//    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
//        productService.update(product.getProductId(), product);
//        redirectAttributes.addFlashAttribute("success", "Edit ok !");
//        return "redirect:/index";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String showFormDelete(@PathVariable int id, Model model) {
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
//        productService.delete(product.getProductId());
//        redirectAttributes.addFlashAttribute("success", "Delete ok !");
//        return "redirect:/index";
//    }
//
//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "/view";
//    }
//
//    @GetMapping("/search")
//    public String searchByName(@RequestParam String name, Model model) {
//        List<Product> products = productService.findByName(name);
//        model.addAttribute("products", products);
//        return "/index";
//    }
//Hie




    @GetMapping("/index")
    public String showList(Model model) {
        model.addAttribute("products", productService.finAll());
        return "/index";
    }

    //Thêm
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product) {
        product.setProductId((int) (Math.random() * 100));
        productService.save(product);
        return "redirect:index";
    }

    //Sửa
    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product) {
        productService.update(product.getProductId(), product);
        return "redirect:index";
    }

    //Xóa
//    @GetMapping("/{id}/delete")
//    public String showFormDelete(@PathVariable int id, Model model) {
//        Product product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("product") Product product) {
//        productService.delete(product.getProductId());
//        return "redirect:index";
//    }

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
        return "/index";
    }
}
