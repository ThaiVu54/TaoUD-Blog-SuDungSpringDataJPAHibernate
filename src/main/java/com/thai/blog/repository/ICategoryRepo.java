package com.thai.blog.repository;

import com.thai.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepo extends PagingAndSortingRepository<Category,Long> {
}
