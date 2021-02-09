package xyz.mynt.blogapi;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class UpdateBlog {
    private String title;
    private String content;
    private String author;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String publishDate;
}
