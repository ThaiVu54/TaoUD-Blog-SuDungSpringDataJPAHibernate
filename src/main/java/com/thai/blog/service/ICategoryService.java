package com.thai.blog.service;

import com.thai.blog.model.Blog;
import com.thai.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
  }
