package Battles;

import Battles.Player.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Battle {
    private Player player1;
    private Player player2;
    private Battle(BattleStarter starter){
        this.player1 = new Player(starter.player1Name, starter.countOfDroids);
        this.player2 = new Player(starter.player2Name, starter.countOfDroids);
    }
    public static class BattleStarter{
        private String player1Name;
        private String player2Name;
        private int countOfDroids;

        public BattleStarter setPlayer1Name(String player1Name){
            this.player1Name = player1Name;
            return this;
        }

        public BattleStarter setPlayer2Name(String player2Name){
            this.player2Name = player2Name;
            return this;
        }

        public BattleStarter setCountOfDroids(int countOfDroids){
            this.countOfDroids = countOfDroids;
            return this;
        }

        public Battle start(){
            return new Battle(this);
        }
    }
    public Player startBattle(){
        Scanner scanner = new Scanner(System.in);
        player1.setDroids();
        player2.setDroids();
        int i = 0;

        while(true){
            System.out.println("Щоб зберегти бій до файлу введіть - -1");

            try {
                i = scanner.nextInt();
            }
            catch (InputMismatchException e){
                scanner.nextLine();
            }

            if(i == -1){
                saveBattleToFile();
            }

            player1.attackEnemyPlayer(player2);
            if (!player2.checkIfHaveLiveDroids()){
                return player1;
            }
            if (!player1.checkIfHaveLiveDroids()){
                return player2;
            }

            player2.attackEnemyPlayer(player1);
            if (!player1.checkIfHaveLiveDroids()){
                return player2;
            }
            if (!player2.checkIfHaveLiveDroids()){
                return player1;
            }

            player1.getBurningDamage();
            player2.getBurningDamage();
        }
    }
    public void saveBattleToFile(){
        try(Writer writer = new FileWriter("D:\\NULP\\2 курс\\ПП\\Лаби\\ЛР3\\Battle.json")){
            Gson gson = new GsonBuilder().create();
            gson.toJson(this, writer);
        }
        catch (IOException e){
            System.out.println("Помилка зберігання до фалйу.");
        }
    }
}
