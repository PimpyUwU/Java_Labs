package Vegetable.Salad;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfSalads {
    private List<Salad> salads;

    public HistoryOfSalads() {
        this.salads = new ArrayList<>();
    }

    public void saveToFile() {
        // Implement the logic to save salads to a file
    }

    public void readFromFile() {
        // Implement the logic to read salads from a file
    }

    public void addSalad(Salad salad) {
        salads.add(salad);
    }

    public void printSalads() {
        salads.forEach(System.out::println);
    }

    public void showSaladDetails(int index) {
        if (index >= 0 && index < salads.size()) {
            System.out.println(salads.get(index));
        } else {
            System.out.println("Invalid index");
        }
    }

    public void deleteSalad(int index) {
        if (index >= 0 && index < salads.size()) {
            salads.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }
}