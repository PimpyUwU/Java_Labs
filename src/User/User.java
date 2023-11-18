package User;

import User.Commands.Command;

public class User {
    Command command;

    public void SetCommandUser(Command command){
        this.command = command;
    }

    public void chooseItem(){
        this.command.execute();
    }

    public boolean isNotNull(){
        return this.command != null;
    }
}
