package gus06.entity.gus.sys.expression1.apply.op._regex_yearp;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}
	
	public static final String KEY_YEARP = "yearp";


	private Service regexFromRule;
	
	public EntityImpl() throws Exception
	{
		regexFromRule = Outside.service(this,"gus.string.transform.regexp.fromrule");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return regexFromRule.r(KEY_YEARP);
	}
}
