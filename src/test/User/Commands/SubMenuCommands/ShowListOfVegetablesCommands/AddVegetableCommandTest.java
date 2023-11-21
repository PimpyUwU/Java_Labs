package User.Commands.SubMenuCommands.ShowListOfVegetablesCommands;

import main.User.Commands.SubMenuCommands.ShowListOfVegetablesCommands.AddVegetableCommand;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class AddVegetableCommandTest {
    private VegetableList vegetableList;
    private AddVegetableCommand addVegetableCommand;

    @BeforeEach
    public void setUp() {
        vegetableList = Mockito.mock(VegetableList.class);
        addVegetableCommand = new AddVegetableCommand(vegetableList);
    }

    @Test
    public void testExecute() {
        String input = "Tomato\nSummer\n20\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        addVegetableCommand.execute();

        verify(vegetableList, times(1)).add(any(Vegetable.class));
    }
}