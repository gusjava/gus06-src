package gus06.entity.gus.string.transform.format.percent.valuetodisplay;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151014";}

	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s==null || s.equals("")) return " ";
		
		double d = Double.parseDouble(s);
		d = d*100;
		return d+" %";
	}
}
