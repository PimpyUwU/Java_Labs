package main.User.Commands.MainMenuCommands;

import main.Menu.Menu;
import main.User.Commands.Command;

public class PrintHistoryCommand implements Command {
    Menu menu;

    public PrintHistoryCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute(){
        menu.printHistory();
    }
}
