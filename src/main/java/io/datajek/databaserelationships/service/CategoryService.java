package io.datajek.databaserelationships.service;

import io.datajek.databaserelationships.onetomany.Tournament;
import io.datajek.databaserelationships.onetoone.Category;
import io.datajek.databaserelationships.repository.CategoryRepository;
import io.datajek.databaserelationships.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id){
        return categoryRepository.findById(id).get();
    }

    public Category addCategory(Category category){
        category.setId(0);
        return categoryRepository.save(category);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
