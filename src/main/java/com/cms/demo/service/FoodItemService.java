package com.cms.demo.service;

import com.cms.demo.entity.FoodItems;
import com.cms.demo.payload.FoodItemDto;

import java.util.List;

public interface FoodItemService {

    FoodItemDto createFood(FoodItemDto foodItemDto,Integer catId);

    FoodItemDto updateFood(FoodItemDto foodItemDto,Integer foodId);

    void deleteFood(Integer foodId);

    //get all food item
    List<FoodItemDto> getAllFood();

    //get single food item
    FoodItemDto getFoodById(Integer foodId);

    //get all food by category
    List<FoodItemDto> getPostByCategory(Integer categoryId);

}
