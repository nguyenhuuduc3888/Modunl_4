package all.controller;

import all.model.Book;
import all.model.Oder;
import all.service.IBookService;
import all.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    //hien thi
    @GetMapping("/list")
    public String getAll(@PageableDefault(value = 4) Pageable pageable, Model model,
                         @RequestParam Optional<String> name) {
        model.addAttribute("name", name.orElse(""));
        model.addAttribute("bookList", bookService.findAll(pageable, name.orElse("")));
        return "/list";
    }

    //them moi
    @GetMapping("/create")
    public String getFormCreate(Model model) {
        model.addAttribute("bookList", new Book());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/list";
    }

    //muon sach
    @GetMapping("/borrow")
    public ModelAndView bookBorrow(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> name, @RequestParam int id) throws Exception {
        Book book = bookService.findById(id);
        if (book.getAmount() == 0) {
            throw new Exception();
        }
        bookService.setBorrowBook(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list", "bookList", bookService.findAll(pageable, name.orElse("")));
        return modelAndView;
    }

    //tra sach
    @GetMapping("/return")
    public ModelAndView bookReturn(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> name, @RequestParam int id) {
        bookService.setReturnBook(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/list", "bookList", bookService.findAll(pageable, name.orElse("")));
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public String showErrPage() {
        return "/error";
    }
}
