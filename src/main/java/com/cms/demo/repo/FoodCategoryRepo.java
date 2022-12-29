package com.cms.demo.repo;

import com.cms.demo.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepo extends JpaRepository<FoodCategory,Integer> {
}
