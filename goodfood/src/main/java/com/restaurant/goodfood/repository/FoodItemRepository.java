package com.restaurant.goodfood.repository;

import com.restaurant.goodfood.model.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {
    // empty
    List<FoodItem> findByFoodNameContainingIgnoreCase(String foodName);
}
