package User.Commands.MainMenuCommands;

import main.User.Commands.MainMenuCommands.MakeSaladCommand;
import main.Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MakeSaladCommandTest {
    private Menu menu;
    private MakeSaladCommand makeSaladCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        makeSaladCommand = new MakeSaladCommand(menu);
    }

    @Test
    public void testExecute() {
        makeSaladCommand.execute();
        verify(menu, times(1)).makeSalad();
    }
}