package Vegetable.Salad;

import Vegetable.VegetableList;
import Vegetable.Vegetable;

public class Salad {
    private VegetableList vegetables;
    private int caloriesPer100g;

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
        System.out.println("Salad: ");
        vegetables.sortByName().forEach(System.out::println);
        System.out.println("Total calories per 100g: " + caloriesPer100g);
    }

    public int getCaloriesPer100g() {
        return caloriesPer100g;
    }
}