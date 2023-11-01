import Battles.Battle;
import Battles.Player.Player;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Battle battle;

        System.out.println("Бажаєте завантажити бій з файлу?\n" +
                "1 - так");
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }

        if (i == 1) {
            try {
                battle = readBattleFromFile();
            }
            catch (FileNotFoundException e){
                System.out.println("У вас немає збережених боїв");
                return;
            }
        }
        else {
            System.out.println("Гравець 1, введіть своє ім'я : ");
            String player1Name = scanner.nextLine();

            System.out.println("Гравець 2, введіть своє ім'я : ");
            String player2Name = scanner.nextLine();

            System.out.println("Якою кількістю дроїдів ви будете битись?");
            int countOfDroids = scanner.nextInt();
            scanner.nextLine();

            battle = new Battle.BattleStarter()
                    .setPlayer1Name(player1Name)
                    .setPlayer2Name(player2Name)
                    .setCountOfDroids(countOfDroids)
                    .start();
        }

        Player winner = battle.startBattle();

        System.out.println("\nПереміг гравець " + winner.getPlayerName());
    }
    public static Battle readBattleFromFile() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("D:\\NULP\\2 курс\\ПП\\Лаби\\ЛР3\\Battle.json"));
        Battle battle = gson.fromJson(reader, Battle.class);
        return battle;
    }
}