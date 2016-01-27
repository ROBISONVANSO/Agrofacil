package br.com.agrofacil.common;

import java.util.List;

public interface GenericDao <T> {
	
	  void delete(T entity);

	    List<T> findAll();

	    T findById(Object id);

	    void create(T entity);

	    T edit(T entity);
	       

}
