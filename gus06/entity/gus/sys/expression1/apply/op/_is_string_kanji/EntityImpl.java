package gus06.entity.gus.sys.expression1.apply.op._is_string_kanji;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160817";}


	private Service check;
	
	public EntityImpl() throws Exception
	{check = Outside.service(this,"gus.filter.string.is.japanese.kanji");}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		if(!(obj instanceof String)) return Boolean.FALSE;
		
		return new Boolean(check.f(obj));
	}
}
