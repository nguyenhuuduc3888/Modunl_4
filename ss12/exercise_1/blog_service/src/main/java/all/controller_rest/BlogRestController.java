package all.controller_rest;

import all.model.Blog;
import all.service.IBlogService;
import all.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//cap quyen
@RequestMapping("/blog/api")
public class BlogRestController {
    @Autowired
    IBlogService blogService;

  //  Hien thi tat ca Blog
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //Tim theo ten
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> findByName(@PathVariable("name")
                                                     Optional<String> name){
        List<Blog> blogList = blogService.findByName(name.orElse(""));
        if (blogList==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
