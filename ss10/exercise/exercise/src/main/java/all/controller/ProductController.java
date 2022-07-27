package all.controller;

import all.dto.CartDto;
import all.dto.ProductDto;
import all.model.Product;
import all.service.IProductService;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService productService;

    //Khởi tạo sesion tên ''cart''
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    //hiển thị
    @GetMapping("")
    public String listProduct(Model model,
                              @CookieValue(value = "idProduct",
                                      defaultValue = "-1") int idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct",
                    productService.findById(idProduct).orElse(null));
        }
        model.addAttribute("product", productService.findAll());
        return "/list";
    }

    @GetMapping("/detail")
    public String viewDetail(@RequestParam int id, Model model, HttpServletResponse response) {
//tạo cooki
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id).orElse(null));
        return "/detail";
    }

    @GetMapping("/add")
    public String addToCard(@RequestParam int id,
                            @ModelAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = productService.findById(id);
        //isPresent kiểm tra xem id có tồn tại hay chưa
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }


}
