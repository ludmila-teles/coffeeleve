package coffeeleve.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    
    private static EntityManagerFactory factory;
    private static EntityManager em;
    
    private static Manager manager;
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    public static Manager getInstance(){
        
        if(manager == null){
            manager = new Manager();
            factory = Persistence.createEntityManagerFactory("CoffeeLeve");
            em = factory.createEntityManager();
        }
        
        return manager;
        
    }

//    public static EntityManager getEntityManager() {
//        return em;
//    }
//    
//    public void connect(String persistenceName){
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceName);
//        em = factory.createEntityManager();
//    }
}
