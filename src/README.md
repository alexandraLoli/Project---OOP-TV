#  OOP Project Milestone 2 - POO TV

#### Assignment Link: [https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2](https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2)


## Skel Structure

* src/
  * checker/ - checker files
  * database/
    * **MoviesDataBase** - the movies database
    * **UsersDataBase** - the users database
    * **DataBase** - contains method to set the database and to reset it and the end of each test
  * entity/
    * **Movie** - contains the characteristics of a movie
    * **User** - contains the characteristics of a user. Implements Observable.
    * **UserCredentials** - contains the credentials of a user
    * **Notifications** - contains the characteristics of a notification to send to the users
  * factory/ - directory which contains classes used to implement the Factory design pattern
    * databaseFactory/ 
      * **EntityFactory** - contains methods *createUser* and *createMovie* to convert Objects received at input in actual User and Movie to add to database 
      * **EntityFactoryProduce** - contains method *getFactory* which returns a specific factory
      * **MovieFactory** - extends EntityFactory
      * **UserFactory** - extends EntityFactory
    * siteFactory/
      * **SiteFactory** - an abstract class which contain method *getPage* that returns an instance of a page
      * **SiteFactoryProduce** - contains method *getFactory* which returns a specific factory  
      * **HomepageAuthenticatedFactory** - extends SiteFactory
      * **HomepageNeauthenticatedFactory** - extends SiteFactory
      * **LoginFactory** - extends SiteFactory
      * **LogoutFactory** - extends SiteFactory
      * **LogoutFactory** - extends SiteFactory
      * **MoviesFactory** - extends SiteFactory
      * **RegisterFactory** - extends SiteFactory
      * **SeeDetailsFactory** - extends SiteFactory
      * **UpgradesFactory** - extends SiteFactory
  * fileio/
    * in/ -contains classes used to read data from the json files
    * ref/ - contains classes used to write data in json files
  * observer/ - directory which contains classes and interfaces used to implement the Observer design pattern
    * **Observable** -  interface which contains methods: 
      * *notify* - to send notifications to users
      * *update* to update movie lists after a movie is deleted
    * **UsersToNotify** - support class for Observer design pattern with methods:
      * *addObserver*
      * *notifyUser* - sends notifications to each user
      * *update* - updates the movie list from each user
  * site/
    * homepageAuthenticated/
      * **HomepageAuthenticated** - class for page homepage authenticated. It extends Site class and overrides methods *onPage*, *changePage* and *back*. Implements the Singleton design pattern.
      * **LogoutPage** - class for logout page . It extends Site class and overrides methods *onPage*, *changePage* and *back*. Implements the Singleton design pattern.
      * **MoviesPage** - class for movies page. It extends Site class and overrides methods *onPage*, *changePage* and *back*. Implements the Singleton design pattern.
      * **SeeDetailsPage** - class for see details page. It extends Site class and overrides methods *onPage*, *changePage* and *back*. Implements the Singleton design pattern.
      * **UpgradesPage** - class for upgrades page. It extends Site class and overrides methods *onPage*, *changePage* and *back*.Implements the Singleton design pattern.
    * homepageNeauthenticated/
      * **HomepageNeauthenticated** - class for page homepage neauthenticated. It extends Site class and overrides methods *onPage*, *changePage* and *back*. Implements the Singleton design pattern.
      * **LoginPage** - class for login page. It extends Site class and overrides methods *onPage* and *back*. Implements the Singleton design pattern.
      * **RegisterPage** - class for register page. It extends Site class and overrides methods *onPage* and *back*. Implements the Singleton design pattern.
    * **Site** - has instances for all strategy interfaces. Implements the Singleton design pattern. Has methods:
      * *useSite* - verifies the current actions and calls the method for the current page;
      * *changePage* - method inherited by classes for each page. Verifies the page the user wants to change to and calls the specific strategy method;
      * *onPage* - method inherited by classes for each page. Verifies the action the user wants to do and calls the specific strategy method;
      * *back* - method inherited by classes for eac page. Its implementation is actually written in Site class. Verifies the previous page and calls the specific change page strategy;
      * *database* - calls the specific special action strategy method and adds movies to database using MovieFactory;
      * *recommend* - steps: </br>
      `1.` goes through the likedMovies list of the current User and creates the Genre Top hashtable </br>
      `2.` if the hashtable is empty, there's no recommendation, otherwise: </br>
      `3.` sort the hashtable by likes / name </br>
      `4.` sort the current user's movie list by likes in reverse order </br>
      `5.` goes through every genre and for every genre, through each movie and check if it was seen, otherwise this movie is the recommended one.
    * **UserLoggedIn** - class for the Current User / the user which is logged in. Implements the Singleton design pattern.
  * strategy/ - directory which contains classes and interfaces used to implement the Strategy Design Pattern
    * changePageStrategy/
      * **ChangePageStrategy** - interface that contains the method *changePage*.
      * **HomepageStrategy** - implements ChangePageStrategy.
      * **PageLoginStrategy** - implements ChangePageStrategy.
      * **PageLogoutStrategy** - implements ChangePageStrategy.
      * **PageMoviesStrategy** - implements ChangePageStrategy.
      * **PageRegisterStrategy** - implements ChangePageStrategy.
      * **PageSeeDetailsStrategy** - implements ChangePageStrategy.
      * **PageUpgradesStrategy** - implements ChangePageStrategy.
    * onPageStrategy/
      * login/
        * **LoginStrategy** - implements OnPageStrategy.
      * movies/
        * **FilterStrategy** - implements OnPageStrategy.
        * **SearchStrategy** - implements OnPageStrategy.
      * register/
        * **RegisterStrategy** - implements OnPageStrategy.
      * seeDetails/
        * **LikeStrategy** - implements OnPageStrategy.
        * **PurchaseStrategy** - implements OnPageStrategy.
        * **RateStrategy** - implements OnPageStrategy.
        * **SubscribeStrategy** - implements OnPageStrategy.
        * **WatchStrategy** - implements OnPageStrategy.
      * upgrades/
        * **BoyTokenStrategy** - implements OnPageStrategy.
        * **BuyPremiumAccountStrategy** - implements OnPageStrategy.
    * OnPageStrategy - interface that contains the method *onPage*.
    * databaseStrategy/
      * **DatabaseStrategy** - interface that contains the method *action*.
      * **DatabaseAddStrategy** - implements DatabaseStrategy.
      * **DatabaseDeleteStrategy**  - implements DatabaseStrategy.
  * Main - read data from input files. Stores users and movies data in database. Access the site.
    Write errors in output files.
  * Test - run the main method from Test class with the name of the input file from the command line.