package User.Commands.MainMenuCommands;

import Menu.Menu;
import User.Commands.Command;

public class PrintAllVegetablesCommand implements Command {
    Menu menu;

    public PrintAllVegetablesCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.printAllVegetables();
    }
}
