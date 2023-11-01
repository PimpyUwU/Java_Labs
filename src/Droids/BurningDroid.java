package Droids;

public class BurningDroid extends Droid {
    private final static int burningDamage = 3;

    public BurningDroid() {
        super(75, 10, "Випалюючий");
    }

    public static int getBurningDamage() {
        return burningDamage;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", Випалюючий демедж = " + getBurningDamage();
    }
}
