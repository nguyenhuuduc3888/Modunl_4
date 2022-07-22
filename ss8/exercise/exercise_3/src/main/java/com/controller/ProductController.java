package com.controller;

import com.dto.ProductDto;
import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 3) Pageable pageable, Model model,
                           @RequestParam Optional<String> name) {
        model.addAttribute("product", productService.findAll(pageable,name.orElse("")));
        return "/list";
    }

    //Them moi
    @GetMapping("/create")
    public String showFormEdit(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
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
        model.addAttribute("productDto", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.update(product);
        return "redirect:/list";
    }

}
