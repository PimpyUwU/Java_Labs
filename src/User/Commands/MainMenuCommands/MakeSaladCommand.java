package User.Commands.MainMenuCommands;

import Menu.Menu;
import User.Commands.Command;

public class MakeSaladCommand implements Command {
    Menu menu;
    public MakeSaladCommand(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void execute(){
        menu.makeSalad();
    }
}
