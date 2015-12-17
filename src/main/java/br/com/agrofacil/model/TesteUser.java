/**
 * 
 */
package br.com.agrofacil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**	
 * @author Robison Vanso
 * @since 13 de dez de 2015
 *
 */
@Entity	
public class TesteUser {

    @Id
    @GeneratedValue				
    private Long Id;
    
    private String name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
