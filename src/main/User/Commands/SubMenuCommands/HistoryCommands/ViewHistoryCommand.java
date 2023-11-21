package main.User.Commands.SubMenuCommands.HistoryCommands;

import main.User.Commands.Command;
import main.Vegetable.Salad.HistoryOfSalads;

public class ViewHistoryCommand implements Command {
    private final HistoryOfSalads historyOfSalads;

    public ViewHistoryCommand(HistoryOfSalads historyOfSalads) {
        this.historyOfSalads = historyOfSalads;
    }

    @Override
    public void execute() {
        historyOfSalads.printSalads();
    }
}