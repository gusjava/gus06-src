package gus06.entity.gus.sys.crypto.pseudo.generator1;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141014";}


	private Service findPseudo;
	private Service generator;

	public EntityImpl() throws Exception
	{
		findPseudo = Outside.service(this,"gus.entitydev.pseudo.find");
		generator = Outside.service(this,"gus.sys.crypto.pseudo.generator");
	}
	
	public Object g() throws Exception
	{
		String pseudo = (String) findPseudo.g();
		if(pseudo==null) return null;
		return generator.t(pseudo);
	}
}
