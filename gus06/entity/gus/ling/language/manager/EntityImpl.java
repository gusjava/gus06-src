package gus06.entity.gus.ling.language.manager;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, G, P {

	public String creationDate() {return "20140719";}

	public static final String KEY = "language";


	private Service langInit;
	private Service save;
	
	private String lang;
	
	
	public EntityImpl() throws Exception
	{
		langInit = Outside.service(this,"gus.ling.language.init");
		save = Outside.service(this,"gus.command.prop2.set");
	}
	
	
	public Object g() throws Exception
	{
		if(lang==null) init();
		return lang;
	}
	
	
	public void p(Object obj) throws Exception
	{
		String newLang = (String) obj;
		if(lang!=null && lang.equals(newLang)) return;
		
		lang = newLang;
		save.v(KEY,lang);
		langChanged();
	}
	
	
	
	
	private void init() throws Exception
	{
		lang = (String) langInit.g();
	}
	
	
	private void langChanged()
	{send(this,"langChanged()");}
}
