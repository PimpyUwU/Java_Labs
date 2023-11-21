package main.Menu;

import main.User.Commands.MainMenuCommands.ExitCommand;
import main.User.Commands.MainMenuCommands.MakeSaladCommand;
import main.User.Commands.MainMenuCommands.PrintAllVegetablesCommand;
import main.User.Commands.MainMenuCommands.PrintHistoryCommand;
import main.User.User;

import java.util.Scanner;

public class MenuRunner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        User user = new User();

        while (true){
            System.out.println("""
                    1 - Список всіх овочів
                    2 - Приготувати салат
                    3 - Історія
                    4 - Вийти з програми
                    """);

            switch (choseItemFromMenu()){
                case(1):
                    user.SetCommandUser(new PrintAllVegetablesCommand(menu));
                    break;
                case(2):
                    user.SetCommandUser(new MakeSaladCommand(menu));
                    break;
                case(3):
                    user.SetCommandUser(new PrintHistoryCommand(menu));
                    break;
                case(4):
                    user.SetCommandUser(new ExitCommand(menu));
                    break;
                default:
                    System.out.println("Хибний номер пункту меню");
            }

            if (user.isNotNull()){
                user.chooseItem();
            }
        }
    }

    public static int choseItemFromMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Виберіть необхідний пункт меню");

        try {
            return scanner.nextInt();
        }
        catch (Exception e){
            return -1;
        }
    }
}
