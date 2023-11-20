package User.Commands.SubMenuCommands.SaladMenuCommands;

import User.Commands.Command;
import Vegetable.Vegetable;
import Vegetable.Salad.Salad;
import Vegetable.VegetableList;

import java.util.Scanner;

public class RemoveVegetableFromSaladCommand implements Command {
    private Salad salad;

    public RemoveVegetableFromSaladCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the vegetable to remove:");

        String name = scanner.nextLine();
        Vegetable vegetableToRemove = salad.getVegetables().findByName(name).stream()
                .findFirst()
                .orElse(null);

        if (vegetableToRemove != null) {
            salad.getVegetables().remove(vegetableToRemove);
            System.out.println("Vegetable removed successfully");
        } else {
            System.out.println("Vegetable not found in salad");
        }
    }
}