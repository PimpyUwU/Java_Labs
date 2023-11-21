package main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.Command;
import main.Vegetable.VegetableList;

public class SortVegetablesBySeasonCommand implements Command {
    private final VegetableList vegetableList;

    public SortVegetablesBySeasonCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        vegetableList.sortBySeazon().forEach(System.out::println);
    }
}