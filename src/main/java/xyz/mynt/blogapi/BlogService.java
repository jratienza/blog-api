package xyz.mynt.blogapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BlogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogService.class);

    private final List<Blog> blogs = new ArrayList<>();
    private final IdService idService;
    public BlogService(IdService idService){
        this.idService = idService;
    }

    public Blog create(CreateBlog createBlog) throws MethodArgumentNotValidException {
        String blogId = idService.getNextUserId();
        Blog newBlog = new Blog(blogId);
        newBlog.setTitle(createBlog.getTitle());
        newBlog.setContent(createBlog.getContent());
        LocalDate parsedBirthDate = LocalDate.parse(createBlog.getPublishDate());
        newBlog.setPublishDate(parsedBirthDate);
        newBlog.setAuthor(createBlog.getAuthor());

        blogs.add(newBlog);
        return newBlog;
    }

    public List<Blog> getBlogs(){
        return blogs;
    }

    public Blog getBlog(String id){
        return blogs.stream().filter(blog -> id.equals(blog.getId())).findFirst().get();
    }

    public void updateBlog(String id,  UpdateBlog update) throws MethodArgumentNotValidException{
        Blog blog = blogs.stream().filter(match -> id.equals(match.getId())).findFirst().get();
        if(!(update.getTitle() == null))
            blog.setTitle(update.getTitle());

        if(!(update.getAuthor() == null))
            blog.setAuthor(update.getAuthor());

        if(!(update.getContent() == null))
            blog.setContent(update.getContent());

        if(!(update.getPublishDate() == null)){
            LocalDate parsedBirthDate = LocalDate.parse(update.getPublishDate());
            blog.setPublishDate(parsedBirthDate);
        }
    }

    public void deleteBlog(String id){
        blogs.removeIf(match -> id.equals(match.getId()));
    }

}
