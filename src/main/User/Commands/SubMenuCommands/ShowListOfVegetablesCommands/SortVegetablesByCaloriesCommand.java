package main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.Command;
import main.Vegetable.VegetableList;

public class SortVegetablesByCaloriesCommand implements Command {
    private final VegetableList vegetableList;

    public SortVegetablesByCaloriesCommand(VegetableList vegetableList) {
        this.vegetableList = vegetableList;
    }

    @Override
    public void execute() {
        vegetableList.sortByCalories().forEach(System.out::println);
    }
}

