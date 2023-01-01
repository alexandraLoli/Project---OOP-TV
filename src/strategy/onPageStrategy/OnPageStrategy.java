package strategy.onPageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;

public interface OnPageStrategy {
   /**
    * Method used to do OnPage actions
    * @param actionsInput
    * @return
    */
   OutputData onPage(ActionsInput actionsInput);
}
