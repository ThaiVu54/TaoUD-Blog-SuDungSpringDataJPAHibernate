package com.thai.blog.controller;

import com.thai.blog.model.Blog;
import com.thai.blog.service.BlogService;
import com.thai.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"blog", "/", ""})
public class BlogController {
    @Autowired
    private IBlogService blogService = new BlogService();

    @GetMapping("")
    public ModelAndView blogForm() {
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "da tao thanh cong");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "sua thanh cong");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute ("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:/blog";
    }
}
