package User.Commands.SubMenuCommands.SaladMenuCommands;

import main.User.Commands.SubMenuCommands.SaladMenuCommands.SaveSaladToHistoryCommand;
import main.Vegetable.Salad.HistoryOfSalads;
import main.Vegetable.Salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class SaveSaladToHistoryCommandTest {
    private Salad salad;
    private HistoryOfSalads historyOfSalads;
    private SaveSaladToHistoryCommand saveSaladToHistoryCommand;

    @BeforeEach
    public void setUp() {
        salad = mock(Salad.class);
        historyOfSalads = mock(HistoryOfSalads.class);
        saveSaladToHistoryCommand = new SaveSaladToHistoryCommand(salad, historyOfSalads);
    }

    @Test
    public void testExecute() {
        String input = "Test Salad";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        saveSaladToHistoryCommand.execute();

        verify(salad, times(1)).setName("Test Salad");
        verify(salad, times(1)).saveSaladToHistory(historyOfSalads);
    }
}