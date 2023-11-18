package Menu;

public class Menu {
    public void printAllVegetables(){
        loop: while (true){
            System.out.println("List of vegetables");
            System.out.println("1 - Вивести відсортований масив\n" +
                    "2 - Знайти овочі\n" +
                    "3 - Додати овоч\n" +
                    "4 - Видалити овоч\n" +
                    "0 - Повернутись до головного меню");

            switch(MenuRunner.choseItemFromMenu()){
                case(1):
                    System.out.println("Відсортований масив");
                    break;
                case(2):
                    System.out.println("Овочі за вказаною хаарктеристикою");
                    break;
                case(3):
                    System.out.println("Додати овоч");
                    break;
                case(4):
                    System.out.println("Видалити овоч");
                    break;
                case(0):
                    break loop;
                default:
                    System.out.println("Хибний номер пункту меню");
            }
        }
    }

    public void makeSalad(){
        loop: while (true) {
            System.out.println("List of vegetables");
            System.out.println("1 - Переглянути список овочів\n" +
                    "2 - Калорійність\n" +
                    "3 - Овочі за діапазоном калорійності\n" +
                    "4 - Приготувати салат\n" +
                    "0 - Повернутись до головного меню");

            switch (MenuRunner.choseItemFromMenu()) {
                case (1):
                    System.out.println("Список овочів");
                    break;
                case (2):
                    System.out.println("Калорійність салату");
                    break;
                case (3):
                    System.out.println("Овочі за діапазоном калорійності");
                    break;
                case (4):
                    System.out.println("Приготувати салат");
                    break;
                case (0):
                    break loop;
                default:
                    System.out.println("Хибний номер пункту меню");
            }
        }
    }

    public void printHistory(){
        System.out.println("Print history");
    }

    public void exit(){System.out.println("exit");}
}
