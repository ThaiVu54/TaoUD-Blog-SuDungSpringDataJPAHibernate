package com.thai.blog.service;

import com.thai.blog.model.Blog;
import com.thai.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll(Pageable pageable);

    Optional findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> findAllAuthorStartsWith(String author, Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);

}
