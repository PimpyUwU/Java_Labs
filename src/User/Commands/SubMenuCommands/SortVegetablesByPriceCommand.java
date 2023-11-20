package User.Commands.SubMenuCommands;

import User.Commands.Command;
import Vegetable.VegetableList;

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