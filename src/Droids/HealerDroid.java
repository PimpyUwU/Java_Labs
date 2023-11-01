package Droids;

import Exceptions.OutOfHealthException;
import Exceptions.WrongHealthValueForDroid;

import java.net.http.WebSocketHandshakeException;

public class HealerDroid extends Droid {
    private final int healing;

    public HealerDroid() {
        super(80, 1, "Хіллер");
        this.healing = 15;
    }

    public int getHealing() {
        return this.healing;
    }

    public void useAbility(Droid friendDroid) throws WrongHealthValueForDroid, OutOfHealthException {
        if (friendDroid.getAlive()){
            friendDroid.setHealth(friendDroid.getHealth() + this.healing);
        }
        else {
            throw new OutOfHealthException();
        }
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", Зцілювання = " + getHealing();

    }
}