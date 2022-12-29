package com.cms.demo.entity;

import com.cms.demo.entity.FoodCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "food_items")
public class FoodItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;


}
