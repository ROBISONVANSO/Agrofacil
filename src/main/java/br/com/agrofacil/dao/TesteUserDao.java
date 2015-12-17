/**
 * 
 */
package br.com.agrofacil.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.agrofacil.model.TesteUser;

/**
 * @author Robison Vanso
 * @since 13 de dez de 2015	
 *		
 */
//@Component
public class TesteUserDao {

    private Session session;
    
    public TesteUserDao(Session session){
	this.session = session;
    }
    
    public void save(TesteUser u){
	this.session.save(u);
    }
    
    public void remove(Long id){
	this.session.delete((TesteUser)	this.session.load(TesteUser.class, id));
	this.session.flush();
    }
    
    public TesteUser load(Long id){
	return (TesteUser) this.session.load(TesteUser.class, id);
    }
    
    public void update(TesteUser u){
	this.session.update(u);
	this.session.flush();
	
    }
    
    @SuppressWarnings("unchecked")
    public List<TesteUser> listAll(){
	return session.createCriteria(TesteUser.class).list();
    }
}
