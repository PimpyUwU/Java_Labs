package User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands.SortVegetablesBySeasonCommand;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SortVegetablesBySeasonCommandTest {
    private VegetableList vegetableList;
    private SortVegetablesBySeasonCommand sortVegetablesBySeasonCommand;

    @BeforeEach
    public void setUp() {
        vegetableList = mock(VegetableList.class);
        sortVegetablesBySeasonCommand = new SortVegetablesBySeasonCommand(vegetableList);
    }

    @Test
    public void testExecute() {
        sortVegetablesBySeasonCommand.execute();
        verify(vegetableList, times(1)).sortBySeazon();
    }
}