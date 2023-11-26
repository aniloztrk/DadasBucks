package com.example.dadasbucks.Controllers;

import com.example.dadasbucks.Models.Drink;
import com.example.dadasbucks.Repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping
    public List<Drink> getDrinksAll(){
        return drinkRepository.findAll();
    }

    @GetMapping("/{categoryId}")
    public List<Drink> getDrinksByCategoryId(@PathVariable Long categoryId){
        return drinkRepository.findAllByCategoryId(categoryId);
    }

    @PostMapping("/add")
    public Drink addDrink(@RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDrink(@PathVariable Long id) {
        Drink drink = drinkRepository.findById(id).orElse(null);
        drinkRepository.delete(drink);
    }

    @PutMapping("/update")
    public Drink updateDrink(@RequestBody Drink newDrink) {
        Drink drink = drinkRepository.findById(newDrink.getId()).orElse(null);
        if(drink == null) return null;

        drink.setName(newDrink.getName());
        drink.setCategoryId(newDrink.getCategoryId());
        drink.setContentText(newDrink.getContentText());
        drink.setPriceText(newDrink.getPriceText());
        return drinkRepository.save(drink);
    }
}
