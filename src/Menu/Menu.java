package Menu;


import User.Commands.SubMenuCommands.*;
import User.Commands.SubMenuCommands.SaladMenuCommands.*;
import Vegetable.Salad.HistoryOfSalads;
import Vegetable.Salad.Salad;
import Vegetable.VegetableList;
import User.User;

public class Menu {
    private User user = new User();

    //all avalivable vegetables
    private Vegetable.VegetableList vegetableList = new VegetableList();
    private Salad salad = new Salad();
    private HistoryOfSalads historyOfSalads = new HistoryOfSalads();

    public void printAllVegetables(){
        loop: while (true){
            System.out.println("List of vegetables");
            System.out.println("1 - Вивести відсортований масив за калорійним споживанням\n" +
                    "2 - Вивести відсортований масив за сезонністю\n" +
                    "3 - Вивести відсортований масив за ціною\n" +
                    "4 - Знайти овочі\n" +
                    "5 - Додати овоч\n" +
                    "6 - Видалити овоч\n" +
                    "0 - Повернутись до головного меню");

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
            System.out.println("Salad preparation");
            System.out.println("1 - View vegetables in salad\n" +
                    "2 - Calculate total calories\n" +
                    "3 - Add vegetable to salad\n" +
                    "4 - Remove vegetable from salad\n" +
                    "5 - Save salad to history\n" +
                    "0 - Return to main menu");

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
                    System.out.println("Invalid menu item");
            }

            if (user.isNotNull()){
                user.chooseItem();
            }
        }
    }

    public void printHistory(){
        System.out.println("Print history");
    }

    public void exit(){System.out.println("exit");}
}
