package gus06.entity.gus.data.time.months.name_fr;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160614";}

	public static final String[] DATA = new String[]{
		"Janvier",
		"F�vrier",
		"Mars",
		"Avril",
		"Mai",
		"Juin",
		"Juillet",
		"Ao�t",
		"Septembre",
		"Octobre",
		"Novembre",
		"D�cembre"
	};
	
	public Object g() throws Exception
	{return DATA;}
}
