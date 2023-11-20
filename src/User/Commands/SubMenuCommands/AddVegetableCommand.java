package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.Vegetable;
import Vegetable.VegetableList;

import java.util.Scanner;

public class AddVegetableCommand implements Command {
    private VegetableList vegetableList;

    public AddVegetableCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details of the vegetable:");

        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println("Season:");
        String season = scanner.nextLine();

        System.out.println("Calories per 100g:");
        int caloriesPer100g = scanner.nextInt();

        System.out.println("Price:");
        int price = scanner.nextInt();

        Vegetable vegetable = new Vegetable(name, season, caloriesPer100g, price);
        vegetableList.add(vegetable);

        System.out.println("Vegetable added successfully");
    }
}