package com.example.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String date;

}
