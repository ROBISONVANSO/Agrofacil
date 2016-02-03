package br.com.agrofacil.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.MessageDrivenContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import br.com.agrofacil.common.GenericDao;

@Stateless
public class GenericDaoJpa<T> implements GenericDao<T> {
//*
    @Resource
    private MessageDrivenContext mdc;
    
    @PersistenceContext
    private EntityManager emPostgre;
    
  //EntityManagerFactory factory = Persistence.createEntityManagerFactory("agrofacilPU");
  //EntityManager manager = factory.createEntityManager();

    private Class<T> persistentClass;

    public GenericDaoJpa() {
        ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
        persistentClass = (Class<T>) thisType.getActualTypeArguments()[0];
    }

    @Override
    public void create(T entity) {
    	//try {
    		emPostgre.persist(entity);	
		//} catch (Exception e) {
			//System.out.println(e.getStackTrace().toString()+ "Vanso");
			//System.out.println(e.getCause().getMessage());
		//}
   
    }

    @Override
    public T edit(T entity) {
        entity = emPostgre.merge(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        entity = emPostgre.merge(entity);
        emPostgre.remove(entity);
    }

    @Override
    public T findById(Object id) {
        return emPostgre.find(persistentClass, id);
    }

    @Override
    public List<T> findAll() {
        String jpqlQuery = "SELECT o FROM " + persistentClass.getName() + " o";
        Query query = emPostgre.createQuery(jpqlQuery);
        return query.getResultList();
    }

//    @Override
//    public void onMessage(Message message) {
//        ObjectMessage msg = null;
//     try {
//          if (message instanceof ObjectMessage) {
//          msg = (ObjectMessage) message;
//              T e = (T) msg.getObject();
//              this.create(e);
//          }
//     } catch (JMSException e) {
//          e.printStackTrace();
//          mdc.setRollbackOnly();
//     } catch (Throwable te) {
//          te.printStackTrace();
//     }    } 

}

