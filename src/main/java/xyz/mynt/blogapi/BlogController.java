package xyz.mynt.blogapi;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BlogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateResponse> create(@Valid @RequestBody CreateBlog request) throws MethodArgumentNotValidException, UnsupportedEncodingException {
        LOGGER.info("Creating blog");
        Blog createdBlog = blogService.create(request);
        CreateResponse response = new CreateResponse();
        response.setId(createdBlog.getId());

        String uriEncodedTitle = URLEncoder.encode(createdBlog.getTitle(),"UTF-8");
        LOGGER.info("Successfully created new blog");
        return ResponseEntity.created(URI.create(uriEncodedTitle)).body(response);

    }

    @GetMapping("/getAll")
    public @ResponseBody ResponseEntity<List> getAll()  {
        return new ResponseEntity<>(blogService.getBlogs(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<Blog> getByID(@PathVariable String id)throws NoSuchElementException{
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody UpdateBlog update, @PathVariable String id) throws NoSuchElementException, MethodArgumentNotValidException{
        blogService.updateBlog(id, update);
        LOGGER.info("Updated blog "+id);
        return ResponseEntity.ok().body("Updated blog :"+ id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable String id) throws NoSuchElementException{
        blogService.deleteBlog(id);
        LOGGER.info("Deleted blog "+id);
        return ResponseEntity.ok().body("Deleted blog " +id);
    }

}
