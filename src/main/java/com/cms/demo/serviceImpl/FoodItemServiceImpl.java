package com.cms.demo.serviceImpl;

import com.cms.demo.entity.FoodCategory;
import com.cms.demo.entity.FoodItems;
import com.cms.demo.exceptions.ResourceNotFoundException;
import com.cms.demo.payload.FoodItemDto;
import com.cms.demo.repo.FoodCategoryRepo;
import com.cms.demo.repo.FoodItemRepo;
import com.cms.demo.service.FoodItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    private FoodItemRepo foodItemRepo;
    @Autowired
    private FoodCategoryRepo foodCategoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public FoodItemDto createFood(FoodItemDto foodItemDto,Integer catId) {
        FoodCategory foodCategory = foodCategoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",catId));
        FoodItems food = modelMapper.map(foodItemDto,FoodItems.class);
        food.setFoodCategory(foodCategory);

        FoodItems createFood = foodItemRepo.save(food);
        return modelMapper.map(createFood, FoodItemDto.class);
    }

    @Override
    public FoodItemDto updateFood(FoodItemDto foodItemDto, Integer foodId) {
        FoodItems food = foodItemRepo.findById(foodId).orElseThrow(()->new ResourceNotFoundException("food","food id",foodId));
        food.setName(foodItemDto.getName());
        food.setPrice(foodItemDto.getPrice());
        food.setQuantity(foodItemDto.getQuantity());

        FoodItems updateFood = foodItemRepo.save(food);
        return modelMapper.map(updateFood,FoodItemDto.class);
    }

    @Override
    public void deleteFood(Integer foodId) {
        FoodItems food = foodItemRepo.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food","food id",foodId));
        foodItemRepo.delete(food);
    }

    @Override
    public List<FoodItemDto> getAllFood() {
        List<FoodItems> allFood = foodItemRepo.findAll();
        List<FoodItemDto> foodDtos = allFood.stream().map((food)->modelMapper.map(food,FoodItemDto.class)).collect(Collectors.toList());
        return foodDtos;
    }

    @Override
    public FoodItemDto getFoodById(Integer foodId) {
        FoodItems food = foodItemRepo.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food Item","Food Id",foodId));
        return modelMapper.map(food,FoodItemDto.class);
    }

    @Override
    public List<FoodItemDto> getPostByCategory(Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        List<FoodItems> foods = foodItemRepo.findByFoodCategory(cat);
        List<FoodItemDto> foodDto = foods.stream().map((food)->modelMapper.map(food,FoodItemDto.class)).collect(Collectors.toList());
        return foodDto;
    }

}
