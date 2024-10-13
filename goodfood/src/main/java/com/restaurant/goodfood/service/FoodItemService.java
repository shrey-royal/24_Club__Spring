package com.restaurant.goodfood.service;

import com.restaurant.goodfood.model.FoodItem;
import com.restaurant.goodfood.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItem insertFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @Query(value = "SELECT * FROM food_item WHERE foodId = :foodId")
    public List<FoodItem> getAllFoodItems() {
        return (List<FoodItem>) foodItemRepository.findAll();
    }

    public FoodItem getFoodItemById(Integer id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    public FoodItem updateFoodItem(Integer id, FoodItem foodItem) {
        Optional<FoodItem> existingFoodItem = foodItemRepository.findById(id);
        if(existingFoodItem.isPresent()) {
            foodItem.setFoodId(id);
            return foodItemRepository.save(foodItem);
        }
        return null;
    }

    public void deleteFoodItem(Integer id) {
        foodItemRepository.deleteById(id);
    }

    public List<FoodItem> findByFoodName(String foodName) {
        return foodItemRepository.findByFoodNameContainingIgnoreCase(foodName);
    }
}
