package gus06.entity.gus.sys.ruleobj1.build.f1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170117";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.filter.string.build.rule1");
	}
	
	public Object t(Object obj) throws Exception
	{
		return perform.t(obj);
	}
}
