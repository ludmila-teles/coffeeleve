package coffeeleve.dao;

import coffeeleve.database.Manager;
import coffeeleve.models.Fornecedor;
import coffeeleve.models.Produto;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class ProdutoDao implements iDao<Produto>{
    
    private EntityManager em;

    public ProdutoDao() {
        Manager manager = Manager.getInstance();
        em = manager.getEntityManager();
    }
    
    @Override
    public boolean save(Produto t) {
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
    public boolean delete(Produto t) {
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
    public List<Produto> listClient() {
      return em.createNamedQuery("findAllProduto", Produto.class).getResultList();
    }

    @Override
    public List<Produto> searchClient(String descricaoproduto) {
        
        return em.createNamedQuery("findByDescricaoProduto", Produto.class).setParameter("descricaoproduto", "%"+descricaoproduto+"%").getResultList();
    }

    @Override
    public boolean update(Produto t) {
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
