package gus06.entity.gus.app.entity.name.own;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140902";}


	private Service findPseudo;


	public EntityImpl() throws Exception
	{
		findPseudo = Outside.service(this,"gus.entitydev.pseudo.find");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String name = (String) obj;
		
		String pseudo = (String) findPseudo.g();
		if(pseudo==null) return false;
		
		return name.startsWith(pseudo+".");
	}
}
