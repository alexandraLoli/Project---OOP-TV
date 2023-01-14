package strategy.onPageStrategy.seeDetails;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public final class SubscribeStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(final ActionsInput actionsInput) {
        String subscribedGenre = actionsInput.getSubscribedGenre();
        for (String i : UserLoggedIn.getInstance().getCurrentUser().getSubscribedGenres()) {
            if (i.equals(subscribedGenre)) {
                return new OutputData();
            }
        }
        for (String i : UserLoggedIn.getInstance().getCurrentMovie().getGenres()) {
            if (i.equals(subscribedGenre)) {
                UserLoggedIn.getInstance()
                        .getCurrentUser().getSubscribedGenres().add(subscribedGenre);
                return null;
            }
        }
        return new OutputData();
    }
}
