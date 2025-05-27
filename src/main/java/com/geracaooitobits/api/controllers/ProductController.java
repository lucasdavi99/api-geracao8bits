package com.geracaooitobits.api.controllers;

import com.geracaooitobits.api.dtos.ProductDTO;
import com.geracaooitobits.api.entities.Product;
import com.geracaooitobits.api.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDTO data) {
        try {
            Product newProduct = productService.createProduct(data);
            return ResponseEntity.ok(newProduct);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
