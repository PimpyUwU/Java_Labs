package test.User.Commands.SubMenuCommands.HistoryCommands;

import main.User.Commands.SubMenuCommands.HistoryCommands.ViewHistoryCommand;
import main.Vegetable.Salad.HistoryOfSalads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ViewHistoryCommandTest {
    private HistoryOfSalads historyOfSalads;
    private ViewHistoryCommand viewHistoryCommand;

    @BeforeEach
    public void setUp() {
        historyOfSalads = mock(HistoryOfSalads.class);
        viewHistoryCommand = new ViewHistoryCommand(historyOfSalads);
    }

    @Test
    public void testExecute() {
        viewHistoryCommand.execute();
        verify(historyOfSalads, times(1)).printSalads();
    }
}