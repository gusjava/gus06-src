package gus06.entity.gus.data.time.months.name_en;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160614";}

	public static final String[] DATA = new String[]{
		"January",
		"February",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September",
		"October",
		"November",
		"December"
	};
	
	public Object g() throws Exception
	{return DATA;}
}
