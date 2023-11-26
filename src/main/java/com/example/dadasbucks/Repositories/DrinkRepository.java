package com.example.dadasbucks.Repositories;

import com.example.dadasbucks.Models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findAllByCategoryId(Long categoryId);
}
