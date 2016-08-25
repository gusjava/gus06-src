package gus06.entity.gus.sys.script1.build1.e;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160504";}
	

	private Service builder;
	private Service getOpMap;

	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.script1.build.e");
		getOpMap = Outside.service(this,"gus.sys.expression1.apply.opmap");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object opMap = getOpMap.g();
		return builder.t(new Object[]{obj,opMap});
	}
}
