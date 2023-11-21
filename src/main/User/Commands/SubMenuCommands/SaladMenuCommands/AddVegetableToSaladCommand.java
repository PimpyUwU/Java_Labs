package main.User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.Command;
import main.Vegetable.Vegetable;
import main.Vegetable.Salad.Salad;
import main.Vegetable.VegetableList;

import java.util.Scanner;

public class AddVegetableToSaladCommand implements Command {
    private Salad salad;
    private VegetableList vegetableList;

    public AddVegetableToSaladCommand(Salad salad, VegetableList vegetableList) {
        this.salad = salad;
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the vegetable to add:");

        String name = scanner.nextLine();
        Vegetable vegetableToAdd = vegetableList.findByName(name).stream()
                .findFirst()
                .orElse(null);

        if (vegetableToAdd != null) {
            salad.getVegetables().add(vegetableToAdd);
            System.out.println("main.Vegetable added successfully");
        } else {
            System.out.println("main.Vegetable not found");
        }
    }
}