package br.com.agrofacil.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.agrofacil.model.Pais;
import br.com.agrofacil.model.TesteEngenhariaReversa;

public class teste {
//	private static final String PERSISTENCE_UNIT = "agrofacilPU";
//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// comentando o teste
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agrofacilPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		Pais pais = new Pais();
		pais.setPaisCod("01");
		pais.setPaisNome("BRASIL");
		pais.setPaisIsExc(false);
		
		manager.persist(pais);
		
		TesteEngenhariaReversa t = new TesteEngenhariaReversa();
	
		t.setTesteBoolean(true);
		t.setTesteChar10("aaaaaaaaa");
		t.setTesteNome("teste 1");
		
		manager.persist(t);
		
		
		trx.commit();

	}

}
