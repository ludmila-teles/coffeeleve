package coffeeleve.dao;

import coffeeleve.database.Manager;
import coffeeleve.models.Fornecedor;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class FornecedorDao implements iDao<Fornecedor>{
    
    private EntityManager em;

    public FornecedorDao() {
        Manager manager = Manager.getInstance();
        em = manager.getEntityManager();
    }

    @Override
    public boolean save(Fornecedor t) {
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
    public boolean delete(Fornecedor t) {
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
    public List<Fornecedor> listClient() {
      return em.createNamedQuery("findAllFornecedor", Fornecedor.class).getResultList();
    }

    @Override
    public List<Fornecedor> searchClient(String razaosocial) {
        
        return em.createNamedQuery("findByRazaoSocial", Fornecedor.class).setParameter("razaosocial", "%"+razaosocial+"%").getResultList();
    }

    @Override
    public boolean update(Fornecedor t) {
        try {
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
