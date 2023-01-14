package site;

import entity.Movie;
import factory.siteFactory.SiteFactoryProduce;
import fileio.input.ActionsInput;
import fileio.input.InputData;
import fileio.output.OutputData;
import strategy.changePageStrategy.*;
import strategy.onPageStrategy.OnPageStrategy;
import strategy.databaseStrategy.DatabaseAddStrategy;
import strategy.databaseStrategy.DatabaseDeleteStrategy;
import strategy.databaseStrategy.DatabaseStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Site {

    public ChangePageStrategy changePageStrategy;
    public OnPageStrategy onPageStrategy;
    public DatabaseStrategy databaseStrategy;

    /**
     * Verify each action and call the corresponding method
     * @param outputData
     * @param inputData
     */
    public static void useSite(final ArrayList<OutputData> outputData,
                               final InputData inputData) {
        for (ActionsInput actionsInput : inputData.getActions()) {
            switch (actionsInput.getType()) {
                case "change page":
                    SiteFactoryProduce.getFactory(
                            UserLoggedIn.getInstance().getCurrentPage()
                    ).getPage().changePage(actionsInput.getPage(), actionsInput, outputData);
                    break;
                case "on page":
                    SiteFactoryProduce.getFactory(
                            UserLoggedIn.getInstance().getCurrentPage()
                    ).getPage().onPage(actionsInput.getFeature(), actionsInput, outputData);
                    break;
                case "back":
                    SiteFactoryProduce.getFactory(
                            UserLoggedIn.getInstance().getCurrentPage()
                    ).getPage().back(outputData, actionsInput);
                    break;
                case "database":
                    SiteFactoryProduce.getFactory(
                            UserLoggedIn.getInstance().getCurrentPage()
                    ).getPage().database(outputData, actionsInput);
                    break;
                default: break;
            }
        }
        if (UserLoggedIn.getInstance().getCurrentUser() != null) {
            if (UserLoggedIn.getInstance().getCurrentUser().getCredentials().getAccountType()
                    .equals("premium")) {
                recommend();
                outputData.add(new OutputData(
                        UserLoggedIn.getInstance().getCurrentUser()
                ));
            }
        }
    }

    /**
     * Method used to change page
     * @param pageName
     * @param actionsInput
     * @param outputData
     */
    public void changePage(final String pageName,
                           final ActionsInput actionsInput,
                           final ArrayList<OutputData> outputData) {

    }

    /**
     * Method used to do OnPage actions
     * @param feature
     * @param actionsInput
     * @param outputData
     */
    public void onPage(final String feature,
                       final ActionsInput actionsInput,
                       final ArrayList<OutputData> outputData) {

    }

    /**
     * Method used to go back with a page
     */
    public void back(final ArrayList<OutputData> outputData,
                     final ActionsInput actionsInput) {
        if (UserLoggedIn.getInstance().getCurrentUser() != null) {
            String previousPage = UserLoggedIn.getInstance().getPagesAccessed().get(
                    UserLoggedIn.getInstance().getPagesAccessed().size() - 2
            );
            switch (previousPage) {
                case "homepage authenticated":
                    this.changePageStrategy = new HomepageStrategy();
                    break;
                case "movies":
                    this.changePageStrategy = new PageMoviesStrategy();
                    break;
                case "upgrades":
                    this.changePageStrategy = new PageUpgradesStrategy();
                    break;
                case "see details":
                    this.changePageStrategy = new PageSeeDetailsStrategy();
                    break;
                case "logout":
                    this.changePageStrategy = new PageLogoutStrategy();
                    break;
                case "login":
                case "register":
                default:
                    this.changePageStrategy = null;
                    break;
            }

            if (this.changePageStrategy == null) {
                outputData.add(new OutputData());
            } else {
                OutputData output = this.changePageStrategy.changePage(actionsInput);
                UserLoggedIn.getInstance().getPagesAccessed().remove(
                        UserLoggedIn.getInstance().getPagesAccessed().size() - 1
                );
                if (output != null) {
                    outputData.add(output);
                }
            }
        } else {
            outputData.add(new OutputData());
        }
    }


    /**
     * Method used to add or delete movies from Database
     * @param outputData
     * @param actionsInput
     */
    public void database(final ArrayList<OutputData> outputData,
                         final ActionsInput actionsInput) {
        switch (actionsInput.getFeature()) {
            case "add":
                this.databaseStrategy = new DatabaseAddStrategy();
                break;
            case "delete":
                this.databaseStrategy = new DatabaseDeleteStrategy();
                break;
            default:
                this.databaseStrategy = null;
        }
        OutputData output = this.databaseStrategy.action(actionsInput);
        if (output != null) {
            outputData.add(output);
        }
    }

    /**
     * Method used to send recommendations
     */
    public static void recommend() {
        UserLoggedIn.getInstance().updateCurrentMovieList();
        for (Movie movie : UserLoggedIn.getInstance().getCurrentUser().getLikedMovies()) {
            for (String genre : movie.getGenres()) {
                boolean ok = false;
                for (Map.Entry<String, Integer> i : UserLoggedIn.getInstance()
                        .getCurrentUser().getGenresTop().entrySet()) {
                    if (i.getKey().equals(genre)) {
                        ok = true;
                        UserLoggedIn.getInstance().getCurrentUser()
                                .getGenresTop().put(genre, i.getValue() + 1);
                    }
                }
                if (!ok) {
                    UserLoggedIn.getInstance().getCurrentUser().getGenresTop().put(genre, 1);
                }
            }
        }
        if (UserLoggedIn.getInstance().getCurrentUser().getGenresTop().size() == 0) {
            UserLoggedIn.getInstance().getCurrentUser().notify(
                    "No recommendation",
                    "Recommendation"
            );
        } else {
            Comparator<Integer> compareByLikes = (Integer i1, Integer i2) -> i1.compareTo(i2);
            Comparator<String> compareByName = (String s1, String s2) -> s1.compareTo(s2);
            LinkedHashMap<String, Integer> sortedMap = UserLoggedIn.getInstance()
                    .getCurrentUser().getGenresTop().entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue(compareByLikes))
                    .sorted(Map.Entry.<String, Integer>comparingByKey(compareByName))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            Collections.sort(
                    UserLoggedIn.getInstance().getCurrentMovieList(),
                    Comparator.comparing(Movie::getNumLikes).reversed()
            );

            Set set = sortedMap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry i = (Map.Entry) iterator.next();
                for (Movie movie : UserLoggedIn.getInstance().getCurrentMovieList()) {
                    boolean ok = true;
                    for (Movie seenMovie : UserLoggedIn.getInstance()
                            .getCurrentUser().getWatchedMovies()) {
                        if (seenMovie.equals(movie)) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        for (String genre : movie.getGenres()) {
                            if (genre.equals(i.getKey())) {
                                UserLoggedIn.getInstance().getCurrentUser().notify(
                                        movie.getName(),
                                        "Recommendation"
                                );
                                return;
                            }
                        }
                    }
                }
            }
            UserLoggedIn.getInstance().getCurrentUser().notify(
                    "No recommendation",
                    "Recommendation"
            );
        }
    }
}
