package com.cms.demo.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class FoodCategoryDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String discription;
}
