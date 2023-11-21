package User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.SubMenuCommands.SaladMenuCommands.AddVegetableToSaladCommand;
import main.Vegetable.Salad.Salad;
import main.Vegetable.Vegetable;
import main.Vegetable.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddVegetableToSaladCommandTest {
    private Salad salad;
    private VegetableList vegetableList;
    private AddVegetableToSaladCommand addVegetableToSaladCommand;

    @BeforeEach
    public void setUp() {
        salad = new Salad();
        vegetableList = new VegetableList();
        addVegetableToSaladCommand = new AddVegetableToSaladCommand(salad, vegetableList);
    }

    @Test
    public void testExecute() {
        String input = "Test Vegetable";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Vegetable vegetable = new Vegetable("Test Vegetable", "Test Season", 100, 200);
        vegetableList.add(vegetable);

        addVegetableToSaladCommand.execute();

        assertNotNull(salad.getVegetables().findByName("Test Vegetable"));
    }
}