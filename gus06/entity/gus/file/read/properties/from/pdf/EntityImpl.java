package gus06.entity.gus.file.read.properties.from.pdf;

import gus06.framework.*;
import java.util.Properties;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151018";}




	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		// A FAIRE : impl�menter ici l'extraction des donn�es meta d'un PDF
		return new Properties();
	}
}
