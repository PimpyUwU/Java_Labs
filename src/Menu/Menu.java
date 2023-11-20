package Menu;

import User.Commands.SubMenuCommands.*;
import User.Commands.SubMenuCommands.SaladMenuCommands.*;
import User.Commands.SubMenuCommands.HistoryCommands.*;
import Vegetable.Salad.HistoryOfSalads;
import Vegetable.Salad.Salad;
import Vegetable.VegetableList;
import User.User;

public class Menu {
    private final User user;

    //all avalivable vegetables
    private final Vegetable.VegetableList vegetableList = new VegetableList();
    private final Salad salad;
    private final HistoryOfSalads historyOfSalads = new HistoryOfSalads();

    public Menu() {
        vegetableList.readFromFile();
        historyOfSalads.readFromFile();
        salad = new Salad();
        user = new User();
    }

    public void printAllVegetables(){
        loop: while (true){
            System.out.println("Список овочів");
            System.out.println("""
                    1 - Вивести відсортований масив за калорійним споживанням
                    2 - Вивести відсортований масив за сезонністю
                    3 - Вивести відсортований масив за ціною
                    4 - Знайти овочі
                    5 - Додати овоч
                    6 - Видалити овоч
                    0 - Повернутись до головного меню""");

            switch(MenuRunner.choseItemFromMenu()){
                case(1):
                    user.SetCommandUser(new SortVegetablesByCaloriesCommand(vegetableList));
                    break;
                case(2):
                    user.SetCommandUser(new SortVegetablesBySeasonCommand(vegetableList));
                    break;
                case(3):
                    user.SetCommandUser(new SortVegetablesByPriceCommand(vegetableList));
                    break;
                case(4):
                    user.SetCommandUser(new FindVegetablesCommand(vegetableList));
                    break;
                case(5):
                    user.SetCommandUser(new AddVegetableCommand(vegetableList));
                    break;
                case(6):
                    user.SetCommandUser(new RemoveVegetableCommand(vegetableList));
                    break;
                case(0):
                    break loop;
                default:
                    System.out.println("Хибний номер пункту меню");
            }

            if (user.isNotNull()){
                user.chooseItem();
            }
        }
    }

    public void makeSalad(){
        loop: while (true) {
            System.out.println("Приготування салату");
            System.out.println("""
                    1 - Переглянути овочі в салаті
                    2 - Розрахувати загальну калорійність
                    3 - Додати овоч до салату
                    4 - Видалити овоч з салату
                    5 - Зберегти салат в історію
                    0 - Повернутись до головного меню""");

            switch (MenuRunner.choseItemFromMenu()) {
                case (1):
                    user.SetCommandUser(new ViewSaladCommand(salad));
                    break;
                case (2):
                    user.SetCommandUser(new CalculateSaladCaloriesCommand(salad));
                    break;
                case (3):
                    user.SetCommandUser(new AddVegetableToSaladCommand(salad, vegetableList));
                    break;
                case (4):
                    user.SetCommandUser(new RemoveVegetableFromSaladCommand(salad));
                    break;
                case (5):
                    user.SetCommandUser(new SaveSaladToHistoryCommand(salad, historyOfSalads));
                    break;
                case (0):
                    break loop;
                default:
                    System.out.println("Неправильний номер пункту меню");
            }

            if (user.isNotNull()){
                user.chooseItem();
            }
        }
    }

    public void printHistory(){
        loop: while (true) {
            System.out.println("Історія салатів");
            System.out.println("""
                    1 - Переглянути всі салати
                    2 - Переглянути деталі салату
                    0 - Повернутись до головного меню""");

            switch (MenuRunner.choseItemFromMenu()) {
                case (1):
                    user.SetCommandUser(new ViewHistoryCommand(historyOfSalads));
                    break;
                case (2):
                    user.SetCommandUser(new ViewSaladDetailsCommand(historyOfSalads));
                    break;
                case (0):
                    break loop;
                default:
                    System.out.println("Неправильний номер пункту меню");
            }

            if (user.isNotNull()){
                user.chooseItem();
            }
        }
    }

    public void exit(){
        historyOfSalads.saveToFile();
        vegetableList.saveToFile();
        System.out.println("Історія та список овочів збережено. Вихід з програми.");
        System.exit(0);
    }
}