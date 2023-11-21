package User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands.FindVegetablesCommand;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class FindVegetablesCommandTest {
    private VegetableList vegetableList;
    private FindVegetablesCommand findVegetablesCommand;

    @BeforeEach
    public void setUp() {
        vegetableList = mock(VegetableList.class);
        findVegetablesCommand = new FindVegetablesCommand(vegetableList);
    }
    @Test
    public void testExecute() {
        String input = "3\nTest";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vegetable vegetable = mock(Vegetable.class);
        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(vegetable);

        when(vegetableList.findByName("Test")).thenReturn(vegetables);

        findVegetablesCommand.execute();

        verify(vegetableList, times(1)).findByName("Test");
    }
}