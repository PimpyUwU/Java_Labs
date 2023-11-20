package User.Commands.SubMenuCommands.SaladMenuCommands;

import User.Commands.Command;
import Vegetable.Salad.HistoryOfSalads;
import Vegetable.Salad.Salad;

import java.util.Scanner;

public class SaveSaladToHistoryCommand implements Command {
    private final Salad salad;
    private final HistoryOfSalads historyOfSalads;

    public SaveSaladToHistoryCommand(Salad salad, HistoryOfSalads historyOfSalads) {
        this.salad = salad;
        this.historyOfSalads = historyOfSalads;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the salad:");
        String saladName = scanner.nextLine();
        salad.setName(saladName);
        salad.saveSaladToHistory(historyOfSalads);
    }
}