package strategy.onPageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface OnPageStrategy {
   OutputData onPage(ActionsInput actionsInput);
}
