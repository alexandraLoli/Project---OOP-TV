package factory.databaseFactory;


public class EntityFactoryProduce {
    /**
     * Return a specific factory to create an entity later
     * @param type for factory type
     * @return needed factory
     */
    public static EntityFactory getFactory(final String type) {
        if ("user".equals(type)) {
            return  new UserFactory();
        } else {
            return new MovieFactory();
        }
    }
}
