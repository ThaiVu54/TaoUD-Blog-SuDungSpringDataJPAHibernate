package com.thai.blog.model;

import javax.persistence.*;

@Entity
@Table(name="blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog() {
    }

    public Blog(Long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
}
