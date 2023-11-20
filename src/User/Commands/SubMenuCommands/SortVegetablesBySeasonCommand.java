package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.VegetableList;

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