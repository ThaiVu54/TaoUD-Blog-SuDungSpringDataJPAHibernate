package com.thai.blog.formatter;

import com.thai.blog.model.Category;
import com.thai.blog.service.CategoryService;
import com.thai.blog.service.IBlogService;
import com.thai.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    public CategoryFormatter(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    //chuyen doi du lieu dau vao sang du lieu yeu cay
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> category = categoryService.findById(Long.parseLong(text));
        return category.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "["+object.getId()+", " +object.getName()+"]";
    }
}
