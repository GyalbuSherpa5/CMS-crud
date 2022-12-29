package com.cms.demo.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class FoodItemDto {

    private Integer id;
    @NotEmpty
    private String name;
    private Integer price;
    private Integer quantity;
    private FoodCategoryDto foodCategory;
}
