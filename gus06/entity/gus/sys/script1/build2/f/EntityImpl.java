package gus06.entity.gus.sys.script1.build2.f;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160829";}
	

	private Service builder;
	private Service getOpMap;

	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.script1.build.f");
		getOpMap = Outside.service(this,"gus.sys.expression1.apply.opmap");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object opMap = getOpMap.g();
		return builder.t(new Object[]{o[0],opMap,o[1]});
	}
}
