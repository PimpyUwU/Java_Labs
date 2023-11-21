package User.Commands.MainMenuCommands;

import main.User.Commands.MainMenuCommands.ExitCommand;
import main.Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ExitCommandTest {
    private Menu menu;
    private ExitCommand exitCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        exitCommand = new ExitCommand(menu);
    }

    @Test
    public void testExecute() {
        exitCommand.execute();
        verify(menu, times(1)).exit();
    }
}