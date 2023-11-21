package User.Commands.SubMenuCommands.HistoryCommands;

import main.User.Commands.SubMenuCommands.HistoryCommands.ViewSaladDetailsCommand;
import main.Vegetable.Salad.HistoryOfSalads;
import main.Vegetable.Salad.Salad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class ViewSaladDetailsCommandTest {
    private HistoryOfSalads historyOfSalads;
    private ViewSaladDetailsCommand viewSaladDetailsCommand;
    private Salad salad;

    @BeforeEach
    public void setUp() {
        historyOfSalads = mock(HistoryOfSalads.class);
        salad = mock(Salad.class);
        viewSaladDetailsCommand = new ViewSaladDetailsCommand(historyOfSalads);
    }

    @Test
    public void testExecute() {
        String input = "Test Salad";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(historyOfSalads.findByName("Test Salad")).thenReturn(salad);

        viewSaladDetailsCommand.execute();

        verify(historyOfSalads, times(1)).findByName("Test Salad");
        verify(salad, times(1)).printSalad();
    }
}