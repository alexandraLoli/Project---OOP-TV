package factory.databaseFactory;


public class EntityFactoryProduce {
    public static EntityFactory getFactory(String type) {
        if ("user".equals(type)) {
            return  new UserFactory();
            }
        else {
            return new MovieFactory();
        }
    }
}
