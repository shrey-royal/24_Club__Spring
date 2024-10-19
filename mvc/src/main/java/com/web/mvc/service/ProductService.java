package com.web.mvc.service;

import com.web.mvc.exception.ProductNotFoundException;
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

    public Product getproductById(long id) {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Product> getProductByName(String name) {
        List<Product> products = productRepository.findProductByNameIgnoreCase(name);

        if(products.isEmpty()) {
            try {
                throw new ProductNotFoundException("Product with name '" + name + "' not found");
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            return products;
        }
    }
}
