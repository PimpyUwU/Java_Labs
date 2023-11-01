package Droids;

import Exceptions.OutOfHealthException;
import Exceptions.WrongHealthValueForDroid;

import java.nio.file.FileAlreadyExistsException;

public class SelfDestructDroid extends Droid{
    private final int damagePercent;

    public SelfDestructDroid(){
        super(50, 1, "Самознищуваний");
        this.damagePercent = 85;
    }

    public int getDamagePercent(){
        return this.damagePercent;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Демедж від спец.вміння = " + getDamagePercent() + "%";
    }

    public void useAbility(Droid enemyDroid){
        try{
            this.setAlive(false);
            enemyDroid.setHealth(enemyDroid.getHealth() - enemyDroid.getHealth() / 100 * this.damagePercent);
        }
        catch (OutOfHealthException e){
            System.out.println("Ви вбили " + enemyDroid.getType());
            enemyDroid.setAlive(false);
        }
        catch (WrongHealthValueForDroid e){
            System.out.println(e);
        }
    }
}
