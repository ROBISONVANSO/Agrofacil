package br.com.agrofacil.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.agrofacil.dao.PaisDaoJpa;
import br.com.agrofacil.model.Pais;
import br.com.agrofacil.model.TesteEngenhariaReversa;

public class teste {
//	private static final String PERSISTENCE_UNIT = "agrofacilPU";
//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// comentando o teste
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("agrofacilPU");
		//EntityManager manager = factory.createEntityManager();
		//EntityTransaction trx = manager.getTransaction();
		
		//trx.begin();
		Pais pais = new Pais();
		pais.setPaisId(1);
		pais.setPaisCod("1053");
		pais.setPaisNome("BRASIL-TESTE2");
		pais.setPaisIsExc(false);
		
		PaisDaoJpa paisDaoJpa = new PaisDaoJpa();
		paisDaoJpa.create(pais);
		
		System.out.println(pais.getPaisId());
		System.err.println(pais.getPaisCod());
		System.out.println(pais.getPaisNome());
		System.out.println(pais.getPaisIsExc());
	
		
		//manager.persist(pais);
		
//		TesteEngenhariaReversa t = new TesteEngenhariaReversa();
//	
//		t.setTesteBoolean(true);
//		t.setTesteChar10("aaaaaaaaa");
//		t.setTesteNome("teste 1");
//		
		//manager.persist(t);
		
		
		//trx.commit();

	}

}
