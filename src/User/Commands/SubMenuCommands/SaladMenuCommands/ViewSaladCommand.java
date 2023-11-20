package User.Commands.SubMenuCommands.SaladMenuCommands;

import User.Commands.Command;
import Vegetable.Salad.Salad;

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