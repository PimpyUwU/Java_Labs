package User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.SubMenuCommands.SaladMenuCommands.RemoveVegetableFromSaladCommand;
import main.Vegetable.Salad.Salad;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class RemoveVegetableFromSaladCommandTest {
    private Salad salad;
    private RemoveVegetableFromSaladCommand removeVegetableFromSaladCommand;

    @BeforeEach
    public void setUp() {
        salad = mock(Salad.class);
        removeVegetableFromSaladCommand = new RemoveVegetableFromSaladCommand(salad);
    }

    @Test
    public void testExecute() {
        String input = "Test Vegetable";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vegetable vegetable = mock(Vegetable.class);
        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(vegetable);

        VegetableList vegetableList = mock(VegetableList.class);
        when(vegetableList.findByName("Test Vegetable")).thenReturn(vegetables);
        when(salad.getVegetables()).thenReturn(vegetableList);

        removeVegetableFromSaladCommand.execute();

        verify(salad.getVegetables(), times(1)).findByName("Test Vegetable");
        verify(salad.getVegetables(), times(1)).remove(vegetable);
    }
}