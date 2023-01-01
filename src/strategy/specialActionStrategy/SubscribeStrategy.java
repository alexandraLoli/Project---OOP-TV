package strategy.specialActionStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

public class SubscribeStrategy implements SpecialActionStrategy{
    @Override
    public OutputData action(ActionsInput actionsInput) {
        String subscribedGenre = actionsInput.getSubscribedGenre();
        for (String i : UserLoggedIn.getInstance().getCurrentUser().getSubscribedGenres()) {
            if (i.equals(subscribedGenre)) {
                return new OutputData();
            }
        }
        for (String i : UserLoggedIn.getInstance().getCurrentMovie().getGenres()) {
            if (i.equals(subscribedGenre)) {
                UserLoggedIn.getInstance().getCurrentUser().getSubscribedGenres().add(subscribedGenre);
                return null;
            }
        }
        return new OutputData();
    }
}
