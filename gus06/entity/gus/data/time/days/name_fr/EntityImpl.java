package gus06.entity.gus.data.time.days.name_fr;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160614";}

	public static final String[] DATA = new String[]{
		"Lundi",
		"Mardi",
		"Mercredi",
		"Jeudi",
		"Vendredi",
		"Samedi",
		"Dimanche"
	};
	
	public Object g() throws Exception
	{return DATA;}
}
