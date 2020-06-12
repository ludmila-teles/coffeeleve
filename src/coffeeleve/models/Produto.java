package coffeeleve.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
@NamedQueries({
    @NamedQuery(name = "findAllProduto", query = "select p from Produto p"),
    @NamedQuery(name = "findByDescricaoProduto", query = "select p from Produto p where p.descricaoproduto like :descricaoproduto")
})

public class Produto implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;
    private String descricaoproduto; 
    private String precocusto;
    private String precovenda ;
    private String unidade;
    private String fornecedor;

   
    public long getId() {
        return id;
    }

 
    public void setId(long id) {
        this.id = id;
    }

   
    public String getDescricaoproduto() {
        return descricaoproduto;
    }

  
    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

  
    public String getPrecocusto() {
        return precocusto;
    }

    
    public void setPrecocusto(String precocusto) {
        this.precocusto = precocusto;
    }

  
    public String getPrecovenda() {
        return precovenda;
    }


    public void setPrecovenda(String precovenda) {
        this.precovenda = precovenda;
    }


    public String getUnidade() {
        return unidade;
    }

 
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }


    public String getFornecedor() {
        return fornecedor;
    }


    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
