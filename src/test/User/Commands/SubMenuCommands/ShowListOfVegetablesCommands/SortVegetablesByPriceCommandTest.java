package User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands.SortVegetablesByPriceCommand;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SortVegetablesByPriceCommandTest {
    private VegetableList vegetableList;
    private SortVegetablesByPriceCommand sortVegetablesByPriceCommand;

    @BeforeEach
    public void setUp() {
        vegetableList = mock(VegetableList.class);
        sortVegetablesByPriceCommand = new SortVegetablesByPriceCommand(vegetableList);
    }

    @Test
    public void testExecute() {
        sortVegetablesByPriceCommand.execute();
        verify(vegetableList, times(1)).sortByPrice();
    }
}