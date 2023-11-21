package test.User.Commands.MainMenuCommands;

import main.User.Commands.MainMenuCommands.PrintAllVegetablesCommand;
import main.Menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PrintAllVegetablesCommandTest {
    private Menu menu;
    private PrintAllVegetablesCommand printAllVegetablesCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        printAllVegetablesCommand = new PrintAllVegetablesCommand(menu);
    }

    @Test
    public void testExecute() {
        printAllVegetablesCommand.execute();
        verify(menu, times(1)).printAllVegetables();
    }
}