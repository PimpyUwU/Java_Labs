package main.User.Commands.MainMenuCommands;

import main.Menu.Menu;
import main.User.Commands.Command;

public class ExitCommand implements Command {
    Menu menu;

    public ExitCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute(){
        menu.exit();
    }
}
