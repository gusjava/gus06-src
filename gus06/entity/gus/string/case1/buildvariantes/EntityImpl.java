package gus06.entity.gus.string.case1.buildvariantes;

import gus06.framework.*;
import java.util.HashMap;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160518";}
	
	public static final String KEY_TITLED = "AAa";
	public static final String KEY_TITLED_INV = "aAa";
	public static final String KEY_UPPER = "AAA";
	public static final String KEY_LOWER = "aaa";
	public static final String KEY_UNDERSCORE = "a_a";
	
	
	
	private Service titled;
	private Service titledInv;
	private Service upper;
	private Service lower;
	private Service underscore;



	public EntityImpl() throws Exception
	{
		titled = Outside.service(this,"gus.string.transform.str.titled");
		titledInv = Outside.service(this,"gus.string.transform.str.titled.inv");
		upper = Outside.service(this,"gus.string.transform.str.upper");
		lower = Outside.service(this,"gus.string.transform.str.lower");
		underscore = Outside.service(this,"gus.string.transform.normalize.diacritics.camelcase.inv");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		Map m = new HashMap();
		
		m.put(KEY_TITLED,	titled.t(s));
		m.put(KEY_TITLED_INV,	titledInv.t(s));
		m.put(KEY_UPPER,	upper.t(s));
		m.put(KEY_LOWER,	lower.t(s));
		m.put(KEY_UNDERSCORE,	underscore.t(s));
		
		return m;
	}
}
