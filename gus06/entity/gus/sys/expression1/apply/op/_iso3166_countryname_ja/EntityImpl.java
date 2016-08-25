package gus06.entity.gus.sys.expression1.apply.op._iso3166_countryname_ja;

import gus06.framework.*;
import java.util.Locale;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160614";}
	
	public static final Locale LOCALE = Locale.JAPANESE;
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return name((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String name(String code) 
	{
		Locale l = new Locale("",code.toUpperCase());
		return l.getDisplayCountry(LOCALE);
	}
}
