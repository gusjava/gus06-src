package gus06.entity.gus.sys.expression1.apply.op._extract_html_h1_f;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170327";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.string.extract.html.block.type.h1.f");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
