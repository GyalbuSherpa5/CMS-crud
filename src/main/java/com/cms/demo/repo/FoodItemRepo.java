package com.cms.demo.repo;

import com.cms.demo.entity.FoodCategory;
import com.cms.demo.entity.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepo extends JpaRepository<FoodItems,Integer> {
    List<FoodItems> findByFoodCategory(FoodCategory foodCategory);
}
