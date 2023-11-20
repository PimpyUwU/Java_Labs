package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.VegetableList;

import java.util.Scanner;

public class FindVegetablesCommand implements Command {
    private final VegetableList vegetableList;

    public FindVegetablesCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть категорію для пошуку овочів:");
        System.out.println("""
                1 - За калорійністю
                2 - За ціною
                3 - За назвою
                4 - За сезоном""");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введіть мінімальну та максимальну калорійність:");
                int minCalories = scanner.nextInt();
                int maxCalories = scanner.nextInt();
                vegetableList.findByCalories(minCalories, maxCalories).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Введіть мінімальну та максимальну ціну:");
                int minPrice = scanner.nextInt();
                int maxPrice = scanner.nextInt();
                vegetableList.findByPrice(minPrice, maxPrice).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Введіть назву:");
                String name = scanner.next();
                vegetableList.findByName(name).forEach(System.out::println);
                break;
            case 4:
                System.out.println("Введіть сезон:");
                String season = scanner.next();
                vegetableList.findBySeazon(season).forEach(System.out::println);
                break;
            default:
                System.out.println("Неправильний вибір");
        }
    }
}