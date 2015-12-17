/**
 * 
 */
package br.com.agrofacil.controller;

import java.util.List;

import br.com.agrofacil.dao.TesteUserDao;
import br.com.agrofacil.model.TesteUser;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

/**
 * @author Robison Vanso
 * @since 13 de dez de 2015
 *
 */
@Controller
public class TesteUsersController {

    private TesteUserDao dao;
    private Result result;
    
    public TesteUsersController(TesteUserDao dao, Result result){
	this.dao = dao;
	this.result = result;
    }
    
    @Post
    @Path("/testeusers")
    public void add(TesteUser user) {
	dao.save(user);
	result.include("mensagem", "Usuário adicionado com Sucesso");
	result.redirectTo(TesteUsersController.class).list();
    }
    
    @Path("/listUsers")
    public List<TesteUser> list() {
    	return dao.listAll();
    }
    
    @Get	
    @Path("/testeusers/{id}")
    public TesteUser view(Long id){
	return dao.load(id);
    }
    
    @Path("/testeusers/delete/{id}")
    public void delete(Long id){
	dao.remove(id);
	result.include("mensagem", "usuário excluído com sucess");
	result.redirectTo(TesteUsersController.class).list();
    }
    
    @Put
    @Path("/testeusers")
    public void edit(TesteUser user){
	dao.update(user);
	result.include("mensagem", "Usuário alterado com Sucesso");
	result.redirectTo(TesteUsersController.class).list();
    }
}
