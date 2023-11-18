package User.Commands.MainMenuCommands;

import Menu.Menu;
import User.Commands.Command;

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
