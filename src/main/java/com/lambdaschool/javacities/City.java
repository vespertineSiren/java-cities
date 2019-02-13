package com.lambdaschool.javacities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class City {

    private @Id @GeneratedValue Long id;
    private String name;
    private int medianPrice;
    private int affordabilityIndex;

    private City(){}

    public City(String name, int medianPrice, int affordabilityIndex) {
        this.name = name;
        this.medianPrice = medianPrice;
        this.affordabilityIndex = affordabilityIndex;
    }
}
