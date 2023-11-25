package main.Vegetable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VegetableList{
    private List<Vegetable> vegetables;
    final static Logger log = Logger.getLogger(VegetableList.class);

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

    public boolean add(Vegetable vegetable) {
        vegetables.add(vegetable);
        return false;
    }

    public void remove(Vegetable vegetable) {
        vegetables.remove(vegetable);
    }

    public void saveToFile() {
        Gson gson = new Gson();
        String json = gson.toJson(vegetables);

        try (FileWriter writer = new FileWriter("vegetableList.json")) {
            writer.write(json);
            log.info("Vegetables saved to file successfully");
        } catch (IOException e) {
            log.error("Error while saving vegetables to file: " + e.getMessage());
        }
    }

    public void readFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("vegetableList.json")) {
            Type listType = new TypeToken<List<Vegetable>>(){}.getType();
            vegetables = gson.fromJson(reader, listType);
            log.info("Vegetables read from file successfully");
        } catch (IOException e) {
            log.error("Error while reading vegetables from file: " + e.getMessage());
        }
    }
}