package User.Commands.MainMenuCommands;

import main.User.Commands.MainMenuCommands.PrintHistoryCommand;
import main.Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PrintHistoryCommandTest {
    private Menu menu;
    private PrintHistoryCommand printHistoryCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        printHistoryCommand = new PrintHistoryCommand(menu);
    }

    @Test
    public void testExecute() {
        printHistoryCommand.execute();
        verify(menu, times(1)).printHistory();
    }
}