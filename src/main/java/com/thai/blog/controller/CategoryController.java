package com.thai.blog.controller;

import com.thai.blog.model.Blog;
import com.thai.blog.model.Category;
import com.thai.blog.service.IBlogService;
import com.thai.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class CategoryController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ModelAndView listForm(Pageable pageable){
        Iterable<Category> categories = categoryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
    @PostMapping("/create-category")
    public ModelAndView creatCate(@ModelAttribute ("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message","thanh cong");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView editCate(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message","thanh cong");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category",category.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }

    }
    @PostMapping("/delete-category")
    public String deleteCate(@ModelAttribute("category")Category category){
        categoryService.remove(category.getId());
        return "redirect:/categories";
    }
    @GetMapping("/view-category/{id}")
    public ModelAndView viewCate(@PathVariable("id") Long id, Pageable pageable){
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
        Iterable<Blog> blogs = blogService.findAllByCategory(category.get(),pageable);
        ModelAndView modelAndView=new ModelAndView("/category/view");
        modelAndView.addObject("category", category.get());
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
}
