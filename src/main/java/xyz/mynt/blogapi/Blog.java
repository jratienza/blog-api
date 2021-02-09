package xyz.mynt.blogapi;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Blog {
    private String id;
    public Blog(String id) {
        this.id = id;
    }

    private String title;
    private String content;
    private LocalDate publishDate;
    private String author;

}
