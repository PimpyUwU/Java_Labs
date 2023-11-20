package User.Commands.SubMenuCommands.HistoryCommands;

import User.Commands.Command;
import Vegetable.Salad.HistoryOfSalads;
import Vegetable.Salad.Salad;

import java.util.Scanner;

public class ViewSaladDetailsCommand implements Command {
    private final HistoryOfSalads historyOfSalads;

    public ViewSaladDetailsCommand(HistoryOfSalads historyOfSalads) {
        this.historyOfSalads = historyOfSalads;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву салату, щоб переглянути деталі:");

        String name = scanner.nextLine();
        Salad salad = historyOfSalads.findByName(name);
        if (salad != null) {
            salad.printSalad();
        } else {
            System.out.println("Салат не знайдено");
        }
    }
}