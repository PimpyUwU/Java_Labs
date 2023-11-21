package User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.SubMenuCommands.SaladMenuCommands.CalculateSaladCaloriesCommand;
import main.Vegetable.Salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CalculateSaladCaloriesCommandTest {
    private Salad salad;
    private CalculateSaladCaloriesCommand calculateSaladCaloriesCommand;

    @BeforeEach
    public void setUp() {
        salad = mock(Salad.class);
        calculateSaladCaloriesCommand = new CalculateSaladCaloriesCommand(salad);
    }

    @Test
    public void testExecute() {
        calculateSaladCaloriesCommand.execute();
        verify(salad, times(1)).updateCaloriesPer100g();
        verify(salad, times(1)).getCaloriesPer100g();
    }
}