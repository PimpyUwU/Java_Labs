package Vegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VegetableList {
    private final List<Vegetable> vegetables;

    public VegetableList() {
        this.vegetables = new ArrayList<>();
    }

    public List<Vegetable> sortByCalories() {
        return vegetables.stream()
                .sorted(Comparator.comparingInt(Vegetable::getCaloriesPer100g))
                .collect(Collectors.toList());
    }

    public List<Vegetable> sortByPrice() {
        return vegetables.stream()
                .sorted(Comparator.comparingInt(Vegetable::getPrice))
                .collect(Collectors.toList());
    }

    public List<Vegetable> sortByName() {
        return vegetables.stream()
                .sorted(Comparator.comparing(Vegetable::getName))
                .collect(Collectors.toList());
    }

    public List<Vegetable> sortBySeazon() {
        return vegetables.stream()
                .sorted(Comparator.comparing(Vegetable::getSeazon))
                .collect(Collectors.toList());
    }

    public List<Vegetable> findByCalories(int min, int max) {
        return vegetables.stream()
                .filter(v -> v.getCaloriesPer100g() >= min && v.getCaloriesPer100g() <= max)
                .collect(Collectors.toList());
    }

    public List<Vegetable> findByPrice(int min, int max) {
        return vegetables.stream()
                .filter(v -> v.getPrice() >= min && v.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Vegetable> findByName(String name) {
        return vegetables.stream()
                .filter(v -> v.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Vegetable> findBySeazon(String seazon) {
        return vegetables.stream()
                .filter(v -> v.getSeazon().equals(seazon))
                .collect(Collectors.toList());
    }

    public void add(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public void remove(Vegetable vegetable) {
        vegetables.remove(vegetable);
    }

    public void printAllVegetables() {
        vegetables.forEach(System.out::println);
    }
}