package User.Commands.SubMenuCommands.SaladMenuCommands;

import User.Commands.Command;
import Vegetable.Salad.Salad;

public class CalculateSaladCaloriesCommand implements Command {
    private Salad salad;

    public CalculateSaladCaloriesCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        salad.updateCaloriesPer100g();
        System.out.println("Total calories per 100g: " + salad.getCaloriesPer100g());
    }
}