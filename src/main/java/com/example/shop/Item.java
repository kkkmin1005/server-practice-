package com.example.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

@Entity
@ToString
public class Item {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id;

    public String title;
    public Integer price;
}
