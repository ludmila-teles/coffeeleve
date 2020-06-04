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
@Table(name="FORNECEDOR")
@NamedQueries({
    @NamedQuery(name = "findAll", query = "select f from Fornecedor f"),
    @NamedQuery(name = "findUser", query = "select f from Fornecedor f where f.razaosocial like :razaosocial")
})
public class Fornecedor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;
    private String razaosocial; 
    private String nomefantasia;
    private String cnpj ;
    private String tel;
    private String email;
    
     
    public long getId() {
        return id;
    }

  
    public void setId(long id) {
        this.id = id;
    }

    
    public String getRazaosocial() {
        return razaosocial;
    }

   
    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

   
    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    
    public String getCnpj() {
        return cnpj;
    }

   
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

  
    public String getTel() {
        return tel;
    }

  
    public void setTel(String tel) {
        this.tel = tel;
    }

 
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
