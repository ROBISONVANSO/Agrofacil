package br.com.agrofacil.controller;

import javax.inject.Inject;

import br.com.agrofacil.model.TesteAplicacao;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class TesteAplicacaoController {

	@Inject
	private Result result;
	
	@Path("testeAplicacao")
	public void TesteAplicacao() {
		System.out.println("Acesso ao Formulario Teste");
		result.forwardTo("WEB-INF/jsp/teste/testeAplicacao.jsp");
	}
	
	@Path("testeAplicacao/salvar")
	public void salvar(TesteAplicacao test) {
		System.out.println("Teste Aplicacao Salvar");
		
		System.out.println(test.getTestNome());
		result.redirectTo(TesteAplicacaoController.class).TesteAplicacao();
	}
}
