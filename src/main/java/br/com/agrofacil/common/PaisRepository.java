package br.com.agrofacil.common;

import java.util.List;

import br.com.agrofacil.model.Pais;

public interface PaisRepository {
	
	    void create(Pais pais);
	    
	    Pais edit(Pais pais);

	    void delete(Pais pais);
	    
	    Pais findById(Object idPAis);

	    List<Pais> findAll();
	    
	    


}
