package com.example.shop;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String title;
    public Integer price;
}
