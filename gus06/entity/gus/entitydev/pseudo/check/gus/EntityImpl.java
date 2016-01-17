package gus06.entity.gus.entitydev.pseudo.check.gus;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140829";}


	private Service findPseudo;
	
	public EntityImpl() throws Exception
	{
		findPseudo = Outside.service(this,"gus.entitydev.pseudo.find");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		if((new File("gus")).exists()) return true;
		String pseudo = (String) findPseudo.g();
		return pseudo!=null && pseudo.equals("gus");
	}
}
