package strategy.databaseStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface DatabaseStrategy {
    /**
     * Method used to delete / add movie
     * @param actionsInput
     * @return
     */
    OutputData action(ActionsInput actionsInput);
}
