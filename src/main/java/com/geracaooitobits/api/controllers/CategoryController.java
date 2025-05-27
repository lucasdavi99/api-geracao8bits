package com.geracaooitobits.api.controllers;

import com.geracaooitobits.api.dtos.CategoryDTO;
import com.geracaooitobits.api.entities.Category;
import com.geracaooitobits.api.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO data) {
        try {
            Category newCategory = categoryService.createCategory(data);
            return ResponseEntity.ok(newCategory);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
