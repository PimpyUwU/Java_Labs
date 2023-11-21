package Menu;

import main.Menu.Menu;
import main.Menu.MenuRunner;
import main.User.Commands.MainMenuCommands.ExitCommand;
import main.User.Commands.MainMenuCommands.PrintAllVegetablesCommand;
import main.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuRunnerTest {
    private User user;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        user = mock(User.class);
        menu = mock(Menu.class);
    }

    @Test
    public void testChoseItemFromMenu() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = MenuRunner.choseItemFromMenu();

        assertEquals(1, result);
    }

    @Test
    public void testChoseWrongItemFromMenu() {
        String input = "qwe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = MenuRunner.choseItemFromMenu();

        assertEquals(-1, result);
    }
}