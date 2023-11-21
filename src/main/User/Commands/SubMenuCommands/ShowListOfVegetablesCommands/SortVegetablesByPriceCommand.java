package main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.Command;
import main.Vegetable.VegetableList;

public class SortVegetablesByPriceCommand implements Command {
    private final VegetableList vegetableList;

    public SortVegetablesByPriceCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        vegetableList.sortByPrice().forEach(System.out::println);
    }
}