package main.User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.Command;
import main.Vegetable.Salad.Salad;

public class ViewSaladCommand implements Command {
    private Salad salad;

    public ViewSaladCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        salad.printSalad();
    }
}