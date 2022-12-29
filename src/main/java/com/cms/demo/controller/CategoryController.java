package com.cms.demo.controller;

import com.cms.demo.service.FoodCategoryService;
import com.cms.demo.payload.ApiResponse;
import com.cms.demo.payload.FoodCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/food")
public class CategoryController {

    @Autowired
    private FoodCategoryService foodCategoryService;

    // post
    @PostMapping("/")
    public ResponseEntity<FoodCategoryDto> createCategory(@Valid @RequestBody FoodCategoryDto foodCategoryDto){
        FoodCategoryDto createFoodCategory = foodCategoryService.createCategory(foodCategoryDto);
        return new ResponseEntity<FoodCategoryDto>(createFoodCategory, HttpStatus.CREATED);
    }

    //put
    @PutMapping("/{categoryId}")
    public ResponseEntity<FoodCategoryDto> updateCategory(@Valid @RequestBody FoodCategoryDto foodCategoryDto,@PathVariable Integer categoryId){
        FoodCategoryDto updateCategory = foodCategoryService.updateCategory(foodCategoryDto,categoryId);
        return new ResponseEntity<FoodCategoryDto>(updateCategory,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        foodCategoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted",true),HttpStatus.OK);
    }

    //get one
    @GetMapping("/{catId}")
    public ResponseEntity<FoodCategoryDto> getCategory(@PathVariable Integer catId){
        FoodCategoryDto foodCategoryDto = foodCategoryService.getCategory(catId);
        return new ResponseEntity<FoodCategoryDto>(foodCategoryDto,HttpStatus.OK);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<FoodCategoryDto>> getCategories(){
        List<FoodCategoryDto> categories = foodCategoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }


}