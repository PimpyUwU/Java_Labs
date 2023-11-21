package User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands.RemoveVegetableCommand;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class RemoveVegetableCommandTest {
    private VegetableList vegetableList;
    private RemoveVegetableCommand removeVegetableCommand;

    @BeforeEach
    public void setUp() {
        vegetableList = mock(VegetableList.class);
        removeVegetableCommand = new RemoveVegetableCommand(vegetableList);
    }

    @Test
    public void testExecute() {
        String input = "Test Vegetable";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vegetable vegetable = mock(Vegetable.class);
        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(vegetable);

        when(vegetableList.findByName("Test Vegetable")).thenReturn(vegetables);

        removeVegetableCommand.execute();

        verify(vegetableList, times(1)).findByName("Test Vegetable");
        verify(vegetableList, times(1)).remove(vegetable);
    }
}