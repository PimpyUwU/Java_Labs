package User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands.SortVegetablesByCaloriesCommand;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SortVegetablesByCaloriesCommandTest {
    private VegetableList vegetableList;
    private SortVegetablesByCaloriesCommand sortVegetablesByCaloriesCommand;

    @BeforeEach
    public void setUp() {
        vegetableList = mock(VegetableList.class);
        sortVegetablesByCaloriesCommand = new SortVegetablesByCaloriesCommand(vegetableList);
    }

    @Test
    public void testExecute() {
        sortVegetablesByCaloriesCommand.execute();
        verify(vegetableList, times(1)).sortByCalories();
    }
}