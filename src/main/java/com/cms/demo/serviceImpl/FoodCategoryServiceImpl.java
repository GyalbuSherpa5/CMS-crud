package com.cms.demo.serviceImpl;

import com.cms.demo.entity.FoodCategory;
import com.cms.demo.exceptions.ResourceNotFoundException;
import com.cms.demo.payload.FoodCategoryDto;
import com.cms.demo.repo.FoodCategoryRepo;
import com.cms.demo.service.FoodCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

    @Autowired
    private FoodCategoryRepo foodCategoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FoodCategoryDto createCategory(FoodCategoryDto foodCategoryDto) {
        FoodCategory cat = modelMapper.map(foodCategoryDto,FoodCategory.class);
        FoodCategory addedCat = foodCategoryRepo.save(cat);
        return modelMapper.map(addedCat,FoodCategoryDto.class);
    }

    @Override
    public FoodCategoryDto updateCategory(FoodCategoryDto foodCategoryDto, Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        cat.setName(foodCategoryDto.getName());
        cat.setDiscription(foodCategoryDto.getDiscription());

        FoodCategory updatedCat = foodCategoryRepo.save(cat);
        return modelMapper.map(updatedCat,FoodCategoryDto.class);

    }

    @Override
    public void deleteCategory(Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        foodCategoryRepo.delete(cat);
    }

    @Override
    public FoodCategoryDto getCategory(Integer categoryId) {
        FoodCategory cat = foodCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        return modelMapper.map(cat,FoodCategoryDto.class);
    }

    @Override
    public List<FoodCategoryDto> getAllCategory() {
        List<FoodCategory> categories = foodCategoryRepo.findAll();
        List<FoodCategoryDto> catDtos = categories.stream().map((cat)->modelMapper.map(cat,FoodCategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
