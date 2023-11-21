package main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.Command;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;

import java.util.Scanner;

public class AddVegetableCommand implements Command {
    private final VegetableList vegetableList;

    public AddVegetableCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть деталі про овоч:");

        System.out.println("Назва:");
        String name = scanner.nextLine();

        System.out.println("Сезон:");
        String season = scanner.nextLine();

        System.out.println("Калорії на 100г:");
        int caloriesPer100g = scanner.nextInt();

        System.out.println("Ціна:");
        int price = scanner.nextInt();

        Vegetable vegetable = new Vegetable(name, season, caloriesPer100g, price);
        vegetableList.add(vegetable);

        System.out.println("Овоч успішно додано");
    }
}