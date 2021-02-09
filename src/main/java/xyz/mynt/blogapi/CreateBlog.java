package xyz.mynt.blogapi;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CreateBlog {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    @NotBlank(message = "Publish date required")
    private String publishDate;

    @NotBlank(message = "Author is required")
    private String author;


}
