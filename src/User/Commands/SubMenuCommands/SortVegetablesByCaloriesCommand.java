package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.VegetableList;

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

