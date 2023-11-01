package Droids;

import Exceptions.OutOfHealthException;
import Exceptions.WrongHealthValueForDroid;

public class Droid {
    private final String type;
    private final int damage;
    private final int basicHealth;
    private int health;
    private boolean isAlive;
    private boolean isBurning;

    public Droid(int basicHealth, int damage, String type) {
        this.basicHealth = basicHealth;
        this.damage = damage;
        this.type = type;
        this.health = basicHealth;
        this.isAlive = true;

    }

    public Droid() {
        this.type = "Дроїд";
        this.basicHealth = 100;
        this.damage = 15;
        this.health = basicHealth;
        this.isAlive = true;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) throws WrongHealthValueForDroid, OutOfHealthException {
        if (health > this.basicHealth) {
            throw new WrongHealthValueForDroid("Wrong health value, max is : " + basicHealth);
        } else if (health <= 0) {
            throw new OutOfHealthException("Droid is out of health");
        } else {
            this.health = health;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void attackDroid(Droid enemy)throws OutOfHealthException{
        try{
            enemy.setHealth(enemy.getHealth() - this.getDamage());
        }
        catch (WrongHealthValueForDroid exp){
            System.out.println("Attack err");
        }

    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean getAlive(){
        return isAlive;
    }

    public void setBurning(){this.isBurning = true;}

    public boolean isBurning(){ return this.isBurning;}

    @Override
    public String toString() {
        return "Тип дроїда = '" + getType() + '\'' +
                ", Кількість здоров'я = " + getHealth() +
                ", Демедж = " + getDamage();
    }
}
