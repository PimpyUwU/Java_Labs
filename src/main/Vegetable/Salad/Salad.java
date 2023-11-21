package main.Vegetable.Salad;

import main.Vegetable.VegetableList;
import main.Vegetable.Vegetable;

public class Salad {
    private String name;
    private final VegetableList vegetables;
    private int caloriesPer100g;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salad() {
        this.vegetables = new VegetableList();
        this.caloriesPer100g = 0;
    }

    public VegetableList getVegetables() {
        return vegetables;
    }

    public void updateCaloriesPer100g() {
        this.caloriesPer100g = vegetables.sortByName().stream()
                .mapToInt(Vegetable::getCaloriesPer100g)
                .sum();
    }

    public void saveSaladToHistory(HistoryOfSalads historyOfSalads) {
        historyOfSalads.addSalad(this);
    }

    public void printSalad() {
        System.out.println("Салат: " + name);
        vegetables.sortByName().forEach(System.out::println);
        System.out.println("Загальна калорійність на 100г: " + caloriesPer100g);
    }

    public int getCaloriesPer100g() {
        return caloriesPer100g;
    }
}