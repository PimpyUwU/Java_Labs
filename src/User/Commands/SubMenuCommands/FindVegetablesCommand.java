package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.VegetableList;

import java.util.Scanner;

public class FindVegetablesCommand implements Command {
    private VegetableList vegetableList;

    public FindVegetablesCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a category to find vegetables:");
        System.out.println("1 - By calories\n" +
                "2 - By price\n" +
                "3 - By name\n" +
                "4 - By season");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the minimum and maximum calories:");
                int minCalories = scanner.nextInt();
                int maxCalories = scanner.nextInt();
                vegetableList.findByCalories(minCalories, maxCalories).forEach(System.out::println);
                break;
            case 2:
                System.out.println("Enter the minimum and maximum price:");
                int minPrice = scanner.nextInt();
                int maxPrice = scanner.nextInt();
                vegetableList.findByPrice(minPrice, maxPrice).forEach(System.out::println);
                break;
            case 3:
                System.out.println("Enter the name:");
                String name = scanner.next();
                vegetableList.findByName(name).forEach(System.out::println);
                break;
            case 4:
                System.out.println("Enter the season:");
                String season = scanner.next();
                vegetableList.findBySeazon(season).forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}