package com.cms.demo.service;

import com.cms.demo.payload.FoodCategoryDto;

import java.util.List;

public interface FoodCategoryService {

    // create
    FoodCategoryDto createCategory(FoodCategoryDto foodCategoryDto);
    // update
    FoodCategoryDto updateCategory(FoodCategoryDto foodCategoryDto, Integer categoryId);
    // delete
    void deleteCategory(Integer categoryId);
    // get single
    FoodCategoryDto getCategory(Integer categoryId);
    // get all
    List<FoodCategoryDto> getAllCategory();
}
