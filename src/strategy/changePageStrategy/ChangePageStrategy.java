package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface ChangePageStrategy {
    OutputData changePage (ActionsInput actionsInput);
}
