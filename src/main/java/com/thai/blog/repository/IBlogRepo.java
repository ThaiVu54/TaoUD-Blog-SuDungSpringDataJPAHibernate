package com.thai.blog.repository;

import com.thai.blog.model.Blog;
import com.thai.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepo extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByAuthorStartsWith(String author, Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);
}
