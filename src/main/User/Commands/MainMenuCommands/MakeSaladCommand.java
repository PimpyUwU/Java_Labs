package main.User.Commands.MainMenuCommands;

import main.Menu.Menu;
import main.User.Commands.Command;

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
