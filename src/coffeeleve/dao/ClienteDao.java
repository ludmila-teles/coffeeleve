package coffeeleve.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import coffeeleve.models.Cliente;


public class ClienteDao implements iDao<Cliente> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CoffeeLeve");
    private EntityManager em = factory.createEntityManager();

    public ClienteDao() {

    }

    @Override
    public boolean save(Cliente t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
        return false;
    }

    @Override
    public boolean delete(Cliente t) {
        try {
             em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
            return false;
        }
    }

    @Override
    public List<Cliente> listClient() {
        
        return em.createNamedQuery("findAll", Cliente.class).getResultList();
    }

    @Override
    public List<Cliente> searchClient(String nome) {
        
        return em.createNamedQuery("findUser", Cliente.class).setParameter("nome", "%"+nome+"%").getResultList();
    }

    @Override
    public boolean update(Cliente t) {
         try {
            //Cliente update = em.find(Cliente.class, t.getId());
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
        return false;
    }

}
