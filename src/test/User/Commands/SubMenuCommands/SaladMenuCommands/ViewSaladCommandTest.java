package User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.SubMenuCommands.SaladMenuCommands.ViewSaladCommand;
import main.Vegetable.Salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ViewSaladCommandTest {
    private Salad salad;
    private ViewSaladCommand viewSaladCommand;

    @BeforeEach
    public void setUp() {
        salad = mock(Salad.class);
        viewSaladCommand = new ViewSaladCommand(salad);
    }

    @Test
    public void testExecute() {
        viewSaladCommand.execute();
        verify(salad, times(1)).printSalad();
    }
}