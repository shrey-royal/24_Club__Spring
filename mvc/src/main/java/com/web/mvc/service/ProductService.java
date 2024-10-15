package com.web.mvc.service;

import com.web.mvc.model.Product;
import com.web.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getproductById(long id) {
        return productRepository.findById(id);
    }
}
