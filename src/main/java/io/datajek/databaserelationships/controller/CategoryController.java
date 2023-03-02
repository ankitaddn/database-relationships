package io.datajek.databaserelationships.controller;

import io.datajek.databaserelationships.onetomany.Tournament;
import io.datajek.databaserelationships.onetoone.Category;
import io.datajek.databaserelationships.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable int id){
        categoryService.deleteCategory(id);
    }
}
