package br.com.agrofacil.controller.enderecamento;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import br.com.agrofacil.model.Pais;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PaisController {

	@Inject
	private Validator validator;
	
	@Inject
	private Result result;
	
	public void form(){
		//...
	}
	
	@Get
	@Path("pais")
	public void pais() {
		System.out.println("Acesso ao Formulário de País");
		result.forwardTo("WEB-INF/jsp/enderecamento/pais/pais.jsp");
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
		
		System.out.println("Chamada do método Adicionar Pais");
		
		if(pais.getPaisNome().isEmpty())
			validator.add(new I18nMessage("error", "campo.obrigatorio", "Nome"));
		
		if(pais.getPaisSg().isEmpty())
			validator.add(new I18nMessage("error", "campo.obrigatorio", "Sigla"));
		
		if(pais.getPaisSg().isEmpty())
			validator.add(new I18nMessage("error", "campo.obrigatorio", "Sigla"));
		
		
		
		Boolean isNew = pais.getPaisId() == null;
		
		if(isNew){
				
//			Calendar calendar = Calendar.getInstance(); 
//			Date data = calendar.getTime(); 
//			DateFormat formataData = DateFormat.getDateInstance(); 
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println(Calendar.getInstance());
			pais.setPaisTsIns(Calendar.getInstance());
			pais.setPaisCod("001");
			pais.setPaisNome("Brasil");
			pais.setPaisSg("BR");
			
			
			//chamar método insert do paisDAO
			
		}else{
			//chamar método update do paisDAO
		}
		
		result.redirectTo(PaisController.class).form();
	}
}
