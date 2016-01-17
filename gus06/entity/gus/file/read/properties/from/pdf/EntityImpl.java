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
		// A FAIRE : implémenter ici l'extraction des données meta d'un PDF
		return new Properties();
	}
}
