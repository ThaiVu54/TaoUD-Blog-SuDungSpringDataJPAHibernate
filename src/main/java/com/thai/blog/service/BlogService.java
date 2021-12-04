package com.thai.blog.service;

import com.thai.blog.model.Blog;
import com.thai.blog.model.Category;
import com.thai.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepo blogRepo;
    @Override
    public Iterable<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public void save(Blog model) {
    blogRepo.save(model);
    }

    @Override
    public void remove(Long id) {
    blogRepo.deleteById(id);
    }

    @Override
    public Page<Blog> findAllAuthorStartsWith(String author, Pageable pageable) {
        return findAllAuthorStartsWith(author,pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(Category category, Pageable pageable) {
        return findAllByCategory(category,pageable);
    }
}
