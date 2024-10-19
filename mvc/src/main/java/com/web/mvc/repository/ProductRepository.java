package com.web.mvc.repository;

import com.web.mvc.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p.id,p.name,p.price FROM product p WHERE LOWER(p.name) = LOWER(:name)")
    List<Product> findProductByNameIgnoreCase(@Param("name") String name);
}
