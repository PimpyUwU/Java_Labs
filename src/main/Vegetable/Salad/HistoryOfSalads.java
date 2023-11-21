package main.Vegetable.Salad;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;

public class HistoryOfSalads {
    private List<Salad> salads;

    public HistoryOfSalads() {
        readFromFile();
    }

    public List<Salad> getSalads() {
        return this.salads;
    }

    public void saveToFile() {
        Gson gson = new Gson();
        String json = gson.toJson(salads);

        try (FileWriter writer = new FileWriter("historyOfSalads.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні салатів у файл: " + e.getMessage());
        }
    }

    public void readFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("historyOfSalads.json")) {
            Type listType = new TypeToken<List<Salad>>() {
            }.getType();
            salads = gson.fromJson(reader, listType);
        } catch (IOException e) {
            this.salads = new ArrayList<>();
        }
    }

    public void addSalad(Salad salad) {
        salads.add(salad);
    }

    public void printSalads() {
        salads.forEach(salad -> System.out.println(salad.getName()));
    }

    public Salad findByName(String name) {
        for (Salad salad : salads) {
            if (salad.getName().equals(name)) {
                return salad;
            }
        }
        return null;
    }
}