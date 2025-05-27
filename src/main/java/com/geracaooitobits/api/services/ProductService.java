package com.geracaooitobits.api.services;

import com.geracaooitobits.api.dtos.ProductDTO;
import com.geracaooitobits.api.entities.Category;
import com.geracaooitobits.api.entities.Product;
import com.geracaooitobits.api.repositories.CategoryRepository;
import com.geracaooitobits.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Product createProduct(ProductDTO data) {
        if (productRepository.findByName(data.name()).isPresent()) {
            throw new RuntimeException("Produto já cadastrado!");
        }

        Category category = categoryRepository.findByName(data.category())
                .orElseThrow(() -> new RuntimeException("Category not found: " + data.category()));

        Product product = new Product();

        product.setName(data.name());
        product.setDescription(data.description());
        product.setPrice(data.price());
        product.setStockQuantity(data.stockQuantity());
        product.setImageUrl(data.imageUrl());
        product.setCategory(category);

        return productRepository.save(product);
    }
}
