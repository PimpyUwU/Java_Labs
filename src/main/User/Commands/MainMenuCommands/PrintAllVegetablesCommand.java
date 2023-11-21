package main.User.Commands.MainMenuCommands;

import main.Menu.Menu;
import main.User.Commands.Command;

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
