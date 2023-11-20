package User.Commands.SubMenuCommands.SaladMenuCommands;

import User.Commands.Command;
import Vegetable.Salad.HistoryOfSalads;
import Vegetable.Salad.Salad;

public class SaveSaladToHistoryCommand implements Command {
    private Salad salad;
    private HistoryOfSalads historyOfSalads;

    public SaveSaladToHistoryCommand(Salad salad, HistoryOfSalads historyOfSalads) {
        this.salad = salad;
        this.historyOfSalads = historyOfSalads;

    }

    @Override
    public void execute() {
        salad.saveSaladToHistory(historyOfSalads);
    }
}