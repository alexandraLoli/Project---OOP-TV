package strategy.specialActionStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface SpecialActionStrategy {
    OutputData action(ActionsInput actionsInput);
}
