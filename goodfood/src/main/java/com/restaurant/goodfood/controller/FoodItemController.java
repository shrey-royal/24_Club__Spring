package com.restaurant.goodfood.controller;

import com.restaurant.goodfood.model.FoodItem;
import com.restaurant.goodfood.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class FoodItemController {

    private final FoodItemService foodItemService;

    @Autowired
    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public String listFoodItems(@RequestParam(required = false) String search, Model model) {
        List<FoodItem> foodItems;

        if(search != null && !search.isEmpty()) {
            foodItems = foodItemService.findByFoodName(search);
            model.addAttribute("search", search);
        } else {
            foodItems = foodItemService.getAllFoodItems();
        }

        model.addAttribute("foodItems", foodItems);
        return "fooditems/list";
    }
}
