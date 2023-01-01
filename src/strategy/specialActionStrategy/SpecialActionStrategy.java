package strategy.specialActionStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface SpecialActionStrategy {
    /**
     * Method used to do other actions than OnPage and ChangePage,
     * such as delete movie, add movie and subscribe to a genre
     * @param actionsInput
     * @return
     */
    OutputData action(ActionsInput actionsInput);
}
