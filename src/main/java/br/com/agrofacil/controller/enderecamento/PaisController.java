package br.com.agrofacil.controller.enderecamento;

import javax.inject.Inject;

import br.com.agrofacil.model.Pais;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Path("/pais")
public class PaisController {

	@Inject
	private Validator validator;
	
	@Inject
	private Result result;
	
	public void form() {
		// ...
	}
	
	public void listar(){
		Pais pais = new Pais();
		
//		Result
	}
	
//	public void excluir(){
//		
//	}
//	
	@Path("adiciona")
	public void adicionar(Pais pais){
		if(pais.getPaisNome().isEmpty())
			validator.add(new I18nMessage("error", "campo.obrigatorio", "Nome"));
		System.out.println("teste adiciona produto");
		
		result.redirectTo(PaisController.class).form();
	}
}
