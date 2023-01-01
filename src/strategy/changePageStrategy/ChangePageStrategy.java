package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface ChangePageStrategy {
    /**
     * Method used to change page
     * @param actionsInput
     * @return
     */
    OutputData changePage(ActionsInput actionsInput);
}
