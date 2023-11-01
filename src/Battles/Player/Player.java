package Battles.Player;
import Droids.*;
import Exceptions.OutOfHealthException;
import Exceptions.WrongHealthValueForDroid;

import java.util.Scanner;

public class Player {
    private final String playerName;
    private final Droid[] droids;
    private int countOfDroids;

    public Player(String playerName, int countOfDroids){
        this.playerName = playerName;
        this.droids = new Droid[countOfDroids];
        this.countOfDroids = 0;
    }

    public void setDroids(){
        Scanner scanner = new Scanner(System.in);
        int type;
        String typeStr;

        while(countOfDroids < droids.length){
            System.out.println("\nГравець " + this.playerName + " виберіть тип дроїда №" +
                    (countOfDroids + 1) +
                    "\n1 - Дроїд\n" +
                    "2 - Випалюючий\n" +
                    "3 - Хіллер\n" +
                    "4 - Самознищуваний\n" +
                    "5 - Танк");

            type = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 1 -> typeStr = "Дроїд";
                case 2 -> typeStr = "Випалюючий";
                case 3 -> typeStr = "Хіллер";
                case 4 -> typeStr = "Самознищуваний";
                case 5 -> typeStr = "Танк";
                default -> throw new RuntimeException("Хибний тип дроїда");
            }
            addDroid(typeStr);
        }
    }

    private void addDroid(String type){
        if(countOfDroids < droids.length){
            //countOfDroids equals next free position in array
            droids[this.countOfDroids] = createDroidByType(type);
            this.countOfDroids++;
        }
        else{
            throw new RuntimeException("Досягнуто максимальної кількості дроїдів");
        }
    }

    private Droid createDroidByType(String type){
        return switch (type) {
            case "Дроїд" -> new Droid();
            case "Випалюючий" -> new BurningDroid();
            case "Хіллер" -> new HealerDroid();
            case "Самознищуваний" -> new SelfDestructDroid();
            case "Танк" -> new Tank();
            default -> throw new RuntimeException("Хибний тип дроїда");
        };
    }

    public void attackEnemyPlayer(Player player2){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nХід гравця " + this.playerName +
                ", виберіть дроїда для атаки");
        Droid playerDroid = choseDroidToAttack();

        if(playerDroid.getType().equals("Дроїд") || playerDroid.getType().equals("Танк")){
            Droid enemyDroid = choseEnemyDroidToAttack(player2);
            try{
                playerDroid.attackDroid(enemyDroid);
            }
            catch (OutOfHealthException exp){
                enemyDroid.setAlive(false);
                System.out.println("Ви вбили " + enemyDroid.getType());
            }
        }
        else if (playerDroid.getType().equals("Хіллер")){
            HealerDroid healerDroid = (HealerDroid) playerDroid;
            System.out.println("Введіть 1 - Для атаки \n" +
                    "Введіть 2 для використання здібності");
            int chose = scanner.nextInt();
            scanner.nextLine();

            if (chose == 1){
                Droid enemyDroid = choseEnemyDroidToAttack(player2);
                try{
                    playerDroid.attackDroid(enemyDroid);
                }
                catch (OutOfHealthException exp){
                    enemyDroid.setAlive(false);
                    System.out.println("Ви вбили " + enemyDroid.getType());
                }
            }
            else {
                try{
                    healerDroid.useAbility(choseDroidToAttack());
                }
                catch (WrongHealthValueForDroid e){
                    System.out.println("Дроїд повністю здоровий\n");
                }
                catch (OutOfHealthException e){
                    System.out.println("Дроїд вже мертвий\n");
                }
            }

        }
        else if (playerDroid.getType().equals("Випалюючий")){
            BurningDroid burningDroid = (BurningDroid) playerDroid;
            Droid enemyDroid = choseEnemyDroidToAttack(player2);

            try{
                playerDroid.attackDroid(enemyDroid);
                enemyDroid.setBurning();
            }
            catch (OutOfHealthException exp){
                enemyDroid.setAlive(false);
                System.out.println("Ви вбили " + enemyDroid.getType());
            }
        }
        else {
            SelfDestructDroid selfDestructDroid = (SelfDestructDroid) playerDroid;
            System.out.println("Введіть 1 - Для атаки \n" +
                    "Введіть 2 для використання здібності");
            int chose = scanner.nextInt();
            scanner.nextLine();

            if (chose == 1){
                Droid enemyDroid = choseEnemyDroidToAttack(player2);
                try{
                    playerDroid.attackDroid(enemyDroid);
                }
                catch (OutOfHealthException exp){
                    enemyDroid.setAlive(false);
                    System.out.println("Ви вбили " + enemyDroid.getType());
                }
            }
            else {
                selfDestructDroid.useAbility(choseEnemyDroidToAttack(player2));
            }
        }
    }

    private Droid choseDroidToAttack(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ваші дроїди : ");

        for (int i = 0; i < this.countOfDroids; i++){
            if(this.droids[i].getAlive()){
                System.out.println("Дроїд " + i + " : " + this.droids[i]);
            }
        }

        System.out.println("Введіть номер дроїда : ");
        int droidNum = scanner.nextInt();
        scanner.nextLine();

        if(droidNum >= 0 && droidNum <= this.countOfDroids){
            return this.droids[droidNum];
        }
        else {
            throw new RuntimeException("Wrong droid index");
        }
    }

    private Droid choseEnemyDroidToAttack(Player enemyPlayer){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nХід гравця " + this.playerName +
                ", виберіть дроїда якого хочете атакувати" +
                "\nВорожі дроїди : ");

        for (int i = 0; i < enemyPlayer.countOfDroids; i++){
            if(enemyPlayer.droids[i].getAlive()) {
                System.out.println("Дроїд " + i + " : " + enemyPlayer.droids[i]);
            }
        }

        System.out.println("Введіть номер дроїда, якого хочете атакувати : ");
        int droidNum = scanner.nextInt();
        scanner.nextLine();

        if(droidNum >= 0 && droidNum <= enemyPlayer.countOfDroids){
            return enemyPlayer.droids[droidNum];
        }
        else {
            throw new RuntimeException("Wrong droid index");
        }
    }

    public boolean checkIfHaveLiveDroids(){
        for(int i = 0; i < this.countOfDroids; i++){
            if (this.droids[i].getAlive()){
                return true;
            }
        }
        return false;
    }

    public void getBurningDamage(){
        for(int i = 0; i < countOfDroids; i++){
            if(droids[i].isBurning()){
                try {
                    droids[i].setHealth(droids[i].getHealth() - BurningDroid.getBurningDamage());
                }
                catch (OutOfHealthException e){
                    droids[i].setAlive(false);
                }
                catch (WrongHealthValueForDroid e){
                    System.out.println(e);
                }
            }
        }
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getCountOfDroids() {
        return this.countOfDroids;
    }
}
