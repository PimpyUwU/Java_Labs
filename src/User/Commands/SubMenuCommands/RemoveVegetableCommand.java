package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.Vegetable;
import Vegetable.VegetableList;

import java.util.Scanner;

public class RemoveVegetableCommand implements Command {
    private final VegetableList vegetableList;

    public RemoveVegetableCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву овоча, який потрібно видалити:");

        String name = scanner.nextLine();
        Vegetable vegetableToRemove = vegetableList.findByName(name).stream()
                .findFirst()
                .orElse(null);

        if (vegetableToRemove != null) {
            vegetableList.remove(vegetableToRemove);
            System.out.println("Овоч успішно видалено");
        } else {
            System.out.println("Овоч не знайдено");
        }
    }
}