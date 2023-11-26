package com.example.dadasbucks.Repositories;

import com.example.dadasbucks.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
