package br.com.agrofacil.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.agrofacil.model.Pais;
import br.com.agrofacil.model.TesteAplicacao;

public class teste {
//	private static final String PERSISTENCE_UNIT = "agrofacilPU";
//
	public static void main(String[] args) {
		
		try {
			http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401
			System.out.println("******************************************************* INICIO EXEMPLOS DE DATA *****************************************");
//			
			System.out.println("\n*********** Recuperação da data com a classe Calendar **********  ");
			Calendar c = Calendar.getInstance(); 
			System.out.println("Data e Hora atual: "+c.getTime());

			System.out.println("\n*********** Recuperando a hora do dia **********  ");
			Calendar c1 = Calendar.getInstance();
			int hr = c1.get(Calendar.HOUR_OF_DAY); 
			if(hr > 6 && hr < 12){ 
				System.out.println("Bom Dia"); 
			}else if(hr > 12 && hr < 18){ 
				System.out.println("Boa Tarde");
			}else{ 
				System.out.println("Boa Noite"); }

			
			System.out.println("\n*********** Formatando data atual **********  ");
			Date data = c.getTime(); 
			System.out.println("Data atual sem formatação: "+data); 
			//Formata a data 
			DateFormat formataData = DateFormat.getDateInstance(); 
			System.out.println("Data atual com formatação: "+ formataData.format(data));
			//Formata Hora 
			DateFormat hora = DateFormat.getTimeInstance(); 
			System.out.println("Hora formatada: "+hora.format(data));
			//Formata Data e Hora 
			DateFormat dtHora = DateFormat.getDateTimeInstance(); 
			System.out.println("Data e Hora: "+ dtHora.format(data)); 
	
			System.out.println("\n*********** Formatações de datas **********  ");
			data = c.getTime(); 
			DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); 
			//Data COmpleta 
			System.out.println("Data brasileira: "+f.format(data)); 
			f = DateFormat.getDateInstance(DateFormat.LONG); 
			System.out.println("Data sem o dia descrito: "+f.format(data)); 
			f = DateFormat.getDateInstance(DateFormat.MEDIUM); 
			System.out.println("Data resumida 1: "+f.format(data)); 
			f = DateFormat.getDateInstance(DateFormat.SHORT); 
			System.out.println("Data resumida 2: "+f.format(data));
	
			System.out.println("\n*********** convertendo Datas com método parse e a classe SimpleDateFormat **********  ");
			f = DateFormat.getDateInstance(); 
			Date data2 = f.parse(formataData.format(data)); 
			System.out.println("Data:"+data2); 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data formatada: "+sdf.format(data)); 
			//Converte Objetos 
			System.out.println("Data convertida: "+sdf.parse(formataData.format(data)));
	
			System.out.println("\n*********** Internacionalizando datas **********  ");
			data = c.getTime(); 
			Locale brasil = new Locale("pt", "BR"); 
			//Retorna do país e a língua 
			Locale eua = Locale.US; 
			Locale italia = Locale.ITALIAN; 
			Locale china = Locale.CHINA;
			
		      Locale locale1 = Locale.CANADA;
		      TimeZone tz1 = TimeZone.getTimeZone("GMT");
		      Calendar cal1 = Calendar.getInstance(tz1, locale1);
//		      System.out.println("\nTimeZone"+tz1);
//		      System.out.println("\nCalendar"+cal1);
		      
		       Calendar cal = Calendar.getInstance(tz1, brasil);
//		      System.out.println("\nTimeZone: "+tz1);
//		      System.out.println("\nCalendar brasil: "+cal1);
		      
		      
		   // display time zone for both calendars
		      String tzname1 = tz1.getDisplayName();
		      String name1 = brasil.getDisplayName();
		      System.out.println("GMT and BRASIL: " + tzname1 + " " + name1);
			
//			 cal = Calendar.getInstance();   // 
//		    System.out.println("\nCalendar's toString() is : " + cal + "\n");
//		    System.out.println("Time zone is: " + cal.getTimeZone() + "\n");
			DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil); 
			System.out.println("Data e hora brasileira: "+f2.format(data)); 
			DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, eua); 
			System.out.println("Data e hora americana: "+f3.format(data)); 
			DateFormat f4 = DateFormat.getDateInstance(DateFormat.FULL, italia); 
			System.out.println("Data e hora italiana: "+f4.format(data));
			DateFormat f5 = DateFormat.getDateInstance(DateFormat.FULL, china); 
			System.out.println("Data e hora china: "+f5.format(data));
			
			
			
			System.out.println("Year  : " + c.get(Calendar.YEAR));
			System.out.println("Month : " + c.get(Calendar.MONTH));
			  System.out.println("Day of Month : " + c.get(Calendar.DAY_OF_MONTH));
			  System.out.println("Day of Week  : " + c.get(Calendar.DAY_OF_WEEK));
			  System.out.println("Day of Year  : " + c.get(Calendar.DAY_OF_YEAR));
			  System.out.println("Week of Year : " + c.get(Calendar.WEEK_OF_YEAR));
			  System.out.println("Week of Month : " + c.get(Calendar.WEEK_OF_MONTH));
			  System.out.println("Day of the Week in Month : " + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
			  System.out.println("Hora  : " + c.get(Calendar.HOUR));
			  System.out.println("AM PM : " + c.get(Calendar.AM_PM));
			  System.out.println("Hora do Dia : " + c.get(Calendar.HOUR_OF_DAY));
			  System.out.println("Minuto : " + c.get(Calendar.MINUTE));
		      System.out.println("Segundo : " + c.get(Calendar.SECOND));
	      System.out.println("\n");

	      
	      
	      
			
			System.out.println("********************************************************* FIM TESTE DATA *****************************************");
			System.out.println();
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		

		// TODO Auto-generated method stub
		// comentando o teste
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agrofacilPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
	
		trx.begin();
		int i = 364;
		int x = 0;  
//		for(x = 365 ; i < x ; i++){
			Locale locale_brasil = new Locale("pt", "BR"); 
		      TimeZone tz1 = TimeZone.getTimeZone("GMT");
		      
//		      System.out.println("###################"+Calendar.getInstance(tz1, locale_brasil));
		      tz1 = TimeZone.getTimeZone("GMT-1");
//		      System.out.println( Calendar.getInstance(tz1, locale_brasil));
		      tz1 = TimeZone.getTimeZone("GMT-3");
//		      System.out.println( Calendar.getInstance(tz1, locale_brasil));
//		      
		      
		      TimeZone tz2 = Calendar.getInstance().getTimeZone();
//		      System.out.println("TIMEZONE: "+tz2);
//		      tz1 = TimeZone.getTimeZone("GMT-2");
		      System.out.println( Calendar.getInstance(tz1, locale_brasil)+"###################");
			Pais pais = new Pais();
			
			Calendar c = Calendar.getInstance(tz1, locale_brasil);
			c.add(Calendar.DATE, i);
			Calendar c2 = Calendar.getInstance(tz2, locale_brasil);
			c2.add(Calendar.DATE, i);
			c.add(Calendar.DATE, i);
		
			pais.setPaisTsIns(c2);
			pais.setPaisTsUpd( c);
			pais.setPaisCod("001");
			pais.setPaisNome("Brasil "+i);
			pais.setPaisSg("BR");
			pais.setPaisIsExc(false);
			
			
			manager.persist(pais);
//		}
		
		TesteAplicacao t = new TesteAplicacao();
	
		t.setTestBoolean(true);
		t.setTestNome("aaaaaaaaa");
		t.setTestDescricao("teste 1");
		
		manager.persist(t);
		trx.commit();
		
	
	}

}
