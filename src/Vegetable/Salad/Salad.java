package Vegetable.Salad;

import Vegetable.VegetableList;
import Vegetable.Vegetable;

public class Salad {
    private VegetableList vegetables;
    private int caloriesPer100g;

    public Salad(VegetableList vegetables) {
        this.vegetables = vegetables;
        this.caloriesPer100g = 0;
    }

    public void updateCaloriesPer100g() {
        this.caloriesPer100g = vegetables.sortByName().stream()
                .mapToInt(Vegetable::getCaloriesPer100g)
                .sum();
    }

    public void saveSaladToHistory() {
        // Implement the logic to save the current salad to history
    }

    public void printSalad() {
        System.out.println("Salad: ");
        vegetables.sortByName().forEach(System.out::println);
        System.out.println("Total calories per 100g: " + caloriesPer100g);
    }
}