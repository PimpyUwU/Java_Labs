package User.Commands.MainMenuCommands;

import Menu.Menu;
import User.Commands.Command;

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
