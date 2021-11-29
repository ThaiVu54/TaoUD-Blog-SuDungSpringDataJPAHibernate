package com.thai.blog.service;

import com.thai.blog.model.Blog;
import com.thai.blog.repository.BlogRepo;
import com.thai.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
     IBlogRepo blogRepo = new BlogRepo();

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public void save(Blog model) {
    blogRepo.save(model);
    }

    @Override
    public void remove(Long id) {
    blogRepo.remove(id);
    }
}
