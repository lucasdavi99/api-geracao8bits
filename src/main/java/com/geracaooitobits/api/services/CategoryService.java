package com.geracaooitobits.api.services;

import com.geracaooitobits.api.dtos.CategoryDTO;
import com.geracaooitobits.api.entities.Category;
import com.geracaooitobits.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(CategoryDTO data){
        if(categoryRepository.findByName(data.name()).isPresent()) {
            throw new RuntimeException("Categoria já cadastrada!");
        }

        Category newCategory = new Category();
        newCategory.setName(data.name());
        newCategory.setDescription(data.description());

        return categoryRepository.save(newCategory);
    }
}
