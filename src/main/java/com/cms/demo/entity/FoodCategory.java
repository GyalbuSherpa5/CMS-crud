package com.cms.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_category")
@NoArgsConstructor
@Getter
@Setter
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String discription;

    @OneToMany(mappedBy = "foodCategory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FoodItems> foodItems = new ArrayList<>();
}