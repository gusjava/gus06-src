package gus06.entity.gus.string.transform.format.number.decimal2;

import gus06.framework.*;
import java.text.DecimalFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150215";}


	private DecimalFormat df;


	public EntityImpl() throws Exception
	{df = new DecimalFormat("#.00");}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		double d = Double.parseDouble(s);
		return df.format(d);
	}
}
