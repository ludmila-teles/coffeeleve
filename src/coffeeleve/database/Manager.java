package coffeeleve.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        return em;
    }
    
    public void connect(String persistenceName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceName);
        em = factory.createEntityManager();
    }
}
