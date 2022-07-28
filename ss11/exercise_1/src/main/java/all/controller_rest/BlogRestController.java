package all.controller_rest;

import all.model.Blog;
import all.service.IBlogService;
import all.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin//cap quyen
@RequestMapping("/blog/api")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    //Hien thi tat ca Blog
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //Xem chi tiet Blog
    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> viewDetail(@PathVariable("id") int id) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }

    //Xem bai viet theo Category
    @GetMapping("/cate/{categoryId}")
    public ResponseEntity<List<Blog>> getCategoryList(@PathVariable("categoryId") int id) {
        List<Blog> listCategoryBlog = blogService.listCategory(id);
        if (listCategoryBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listCategoryBlog, HttpStatus.OK);
    }

    //Them moi
    @PostMapping("/add")
    public ResponseEntity addBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Cap nhat
    @PutMapping("/update")
    public ResponseEntity updateBlog(@RequestBody Blog blog) {
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        blogService.update(blog);
        return new ResponseEntity(blog, HttpStatus.OK);
    }

    //Xoa Blog
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable("id") int id) {
        blogService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
