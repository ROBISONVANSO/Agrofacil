package br.com.agrofacil.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.MessageDrivenContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import antlr.debug.MessageEvent;
import antlr.debug.MessageListener;
import antlr.debug.TraceEvent;
import br.com.agrofacil.common.GenericDao;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.ObjectMessage;

public class GenericDaoJpa<T> implements GenericDao<T> {

    @Resource
    private MessageDrivenContext mdc;
    
    @PersistenceContext(unitName = "CCPR-ejb")
    private EntityManager emPostgre;

    private Class<T> persistentClass;

    public GenericDaoJpa() {
        ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
        persistentClass = (Class<T>) thisType.getActualTypeArguments()[0];
    }

    @Override
    public void create(T entity) {
        emPostgre.persist(entity);
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
/*
    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
     try {
          if (message instanceof ObjectMessage) {
          msg = (ObjectMessage) message;
              T e = (T) msg.getObject();
              this.create(e);
          }
     } catch (JMSException e) {
          e.printStackTrace();
          mdc.setRollbackOnly();
     } catch (Throwable te) {
          te.printStackTrace();
     }    } */

}

