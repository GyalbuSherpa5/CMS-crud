package com.cms.demo.controller;

import com.cms.demo.payload.ApiResponse;
import com.cms.demo.repo.FoodItemRepo;
import com.cms.demo.service.FoodItemService;
import com.cms.demo.payload.FoodItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;
    @Autowired
    private FoodItemRepo foodItemRepo;

    //create
    @PostMapping("/category/{catId}/foodItem")
    public ResponseEntity<FoodItemDto> createFood(@RequestBody FoodItemDto foodItemDto, @PathVariable Integer catId){
        FoodItemDto createFood = foodItemService.createFood(foodItemDto,catId);
        return new ResponseEntity<FoodItemDto>(createFood, HttpStatus.CREATED);
    }

    // get by category
    @GetMapping("/category/{categoryId}/foods")
    public ResponseEntity<List<FoodItemDto>> getByCategory(@PathVariable Integer categoryId){
        List<FoodItemDto> foods = foodItemService.getPostByCategory(categoryId);
        return new ResponseEntity<List<FoodItemDto>>(foods,HttpStatus.OK);
    }

    // get all
    @GetMapping("/foods")
    public ResponseEntity<List<FoodItemDto>> getAllFoods(){
        List<FoodItemDto> allFood = foodItemService.getAllFood();
        return new ResponseEntity<List<FoodItemDto>>(allFood,HttpStatus.OK);
    }

    // get by id
    @GetMapping("/{foodId}/foods")
    public ResponseEntity<FoodItemDto> getFoodById(@PathVariable Integer foodId){
        FoodItemDto food = foodItemService.getFoodById(foodId);
        return new ResponseEntity<FoodItemDto>(food,HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{foodId}/foods")
    public ResponseEntity<ApiResponse> deleteFood(@PathVariable Integer foodId){
        foodItemService.deleteFood(foodId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("deleted",true),HttpStatus.OK);
    }

    //update
    @PutMapping("/foods/{foodId}")
    public ResponseEntity<FoodItemDto> updateFood(@RequestBody FoodItemDto foodItemDto,@PathVariable Integer foodId){
        FoodItemDto update = foodItemService.updateFood(foodItemDto,foodId);
        return new ResponseEntity<FoodItemDto>(update,HttpStatus.OK);
    }

}
