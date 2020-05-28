package coffeeleve.dao;

import java.util.List;


public interface iDao <T>{
    public boolean save(T t);
    public boolean delete(T t);
    public List<T> listClient();
    public List<T> searchClient(String nome);
    public boolean update(T t);
}
