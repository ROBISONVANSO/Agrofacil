package br.com.agrofacil.teste;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.servlet.ServletContext;

import br.com.caelum.vraptor.http.InvalidParameterException;

/**
 * http://carlos.inf.br/2011/03/24/componente-para-internacionalizacao-de-javascript-no-vraptor-3/
 * Componente do VRaptor para fazer um deploy automático dos arquivos Javascript de
 * internacionalização da aplicação. Os arquivos JS gerados contém uma implementação de
 * um plugin jQuery que pode ser acessado através da seguinte chamada.
 * alert ( $('minha.chave.i18n') );
 * 
 * Assim de acordo com o locale atual, será carregado automaticamente o respectivo arquivo
 * JS com as mensagens internacionalizadas para apresentar ao usuário da aplicação.
 * 
 * @author Carlos A. Junior (CIH - Centro Internacional de Hidroinformática)
 * 
 * @author Lucas Diedrich (CIH - Centro Internacional de Hidroinformática)
 * 
 * @see ProtectionDomain
 * 
 * @see CodeSource
 * 
 */
@ApplicationScoped
public class ResourceBundleJavascriptExport
{
//	private static final Logger logger = Logger.getLogger(ResourceBundleJavascriptExport.class);
	
	/**
	 * Maintains of relative folder of this class. Method <code>getCodeSource().getLocation()</code> is a
	 * collaboration of Lucas Diedrich.
	 */
	private File relative = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getFile());

	/**
	 * Instance of application parameters.
	 */
	private ServletContext context;
	
//	/**
//	 * Default construtor with dependency injection of ServletContext object.
//	 * 
//	 * @param context
//	 */
//	public ResourceBundleJavascriptExport ()
//	{
//		//..
//	}
	
	public void whenApplicationStarts(@Observes ServletContext context) {
        System.out.println("Gerado arquivo de message. properties");
        this.context = context;
		this.getApplicationLocales();
    }
	
	/**
	 * Returns an List of Locale objects based in the 'locales' parameter of web.xml. All
	 * locales specified should be separated by commas.<br/> <br/> 
	 * 
	 * <code>E.g: pt_BR,en,es</code>
	 * 
	 * @return List
	 * 
	 * @throws InvalidParameterException - when 'locales' parameter is null or empty.
	 */
	public List<Locale> getApplicationLocales()
	{
		String s = "pt_BR";
	//	String s = this.context.getInitParameter("locales");
		
		String[] languages = s != null ? s.split(",") : null;
		
		if(languages == null || languages.length == 0)
		{
			throw new InvalidParameterException("Could not find any languages in web.xml 'locales' parameter.");
		}
		
		List<Locale> locales = new ArrayList<Locale>();
		
		for (String lang : languages)
		{
			locales.add(new Locale(lang));
		}
		
		return locales;
	}
	
	/**
	 * Deploy an new Javascript file based in the content of ResourceBundle
	 * object. The target folder is WEB-INF/js/i18n/. All files using the
	 * current charset of 'br.com.caelum.vraptor.encoding' parameter.
	 * 
	 * @param File properties
	 * 
	 * @throws IOException - throws when the target dir could not be created 
	 * or Javascript file creation fail.
	 * 
	 * @see web.xml 'br.com.caelum.vraptor.encoding' parameter
	 */
	private void deployI18nJavascriptFile(ResourceBundle bundle)
	{
		if(bundle != null)
		{
			try
			{
				Enumeration<String> enumeration = bundle.getKeys();
				
				String keys = "\t\t";
				int i = 0;
				while(enumeration.hasMoreElements())
				{
					String key = enumeration.nextElement();
					
					if(i > 0 && i%3 == 0)
					{
						keys += "\n\t\t";
					}
					
					// Fix quotation marks and break lines of an String.
					String traducao = bundle.getString(key).replaceAll("'", "\'");
					traducao = traducao.replaceAll("\\n", "\\\\n");
					
					keys += "m[\"" + key + "\"] = \"" + traducao + "\";\n\t\t";
					i++;
				}
				
				if(keys.length() > 2)
				{
					if(keys.endsWith("\t\t"))
					{
						keys = keys.replaceAll("\t\t$", "\t");
					}
					
					String plugin 	 = "jQuery( function($)\n";
					plugin 			+= "{\n";
					plugin 			+= "\t$.msg = function (key)\n";
					plugin 			+= "\t{\n";
					plugin 			+= "\t\tvar m = new Array();\n\n";
					plugin 			+= keys;
					plugin			+= "\n\t\tvar msg = m[key];\n\t";
					plugin			+= "\n\t\tmsg = (msg == undefined) ? ('??[' + key + ']??') : msg;\n\t";
					plugin			+= "\n\t\treturn msg;\n\t";
					plugin 			+= "}\n";
					plugin 			+= "});";
					
					// Write content to new Javascript file.
					this.createI18nJavascriptFile(plugin, bundle.getLocale());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method creates an new Javascript file with the jQuery plugin content ($.msg). If
	 * the file exists, the same will be replaced.
	 * 
	 * @param content - The jQuery plugin content.
	 * 
	 * @param locale - Locale to set a name of file. E.g: messages_pt_BR.properties
	 * 
	 * @throws IOException - For file operations.
	 */
	private void createI18nJavascriptFile (String content, Locale locale) throws IOException
	{
		// Ensures that the file is at the root of WebContent
		File parent = relative.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile();
//		File parent = relative.getParentFile().getParentFile();
		
		File dir = new File(
			parent.getCanonicalPath() + File.separator + "js" + File.separator + "i18n" + File.separator
		);
		
		if(!dir.exists())
		{
			dir.mkdirs();
		}
		
		if(!dir.exists())
		{
			throw new IOException("Could not create the destination folder of i18n javascript files.");
		}
		
		File js = new File(
			parent.getCanonicalPath() + File.separator + "js" + File.separator + "i18n" + File.separator + "messages_" + locale + ".js"
		);
		
		// Delete and create.
		if(js.exists())
		{
			js.delete();
		}
		js.createNewFile();
		
//		String charset = this.context.getInitParameter("br.com.caelum.vraptor.encoding");
		String charset = null;
		if(charset == null || charset.isEmpty())
		{
			charset = "UTF-8";
		}
		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(js), charset));
        
        bw.write(content);
        bw.close();
	}
	
	/**
	 * This method is automatically invoked by conteiner after the instantiation of this 
	 * class across @PostConstruct annotation. 
	 */
	@PostConstruct
	public void initI18nJavascriptFilesDeploy ()
	{
		System.out.println("Generating the Javascript files for i18n.");
		try
		{
			List<Locale> locales = this.getApplicationLocales();
			
			for (Locale locale : locales)
			{
				ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
				this.deployI18nJavascriptFile(bundle);
			}
		} catch (Exception e) {
			System.out.println("Could not deploy the Javascript files with error message " + e.getMessage());
			e.printStackTrace();
		}
	}
}