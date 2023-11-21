package User;

import main.User.User;
import main.User.Commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private Command command;

    @BeforeEach
    public void setUp() {
        user = new User();
        command = mock(Command.class);
    }

    @Test
    public void testSetCommandUser() {
        user.SetCommandUser(command);
        assertTrue(user.isNotNull());
    }

    @Test
    public void testChooseItem() {
        user.SetCommandUser(command);
        user.chooseItem();
        verify(command, times(1)).execute();
    }

    @Test
    public void testIsNotNull() {
        assertFalse(user.isNotNull());
        user.SetCommandUser(command);
        assertTrue(user.isNotNull());
    }
}