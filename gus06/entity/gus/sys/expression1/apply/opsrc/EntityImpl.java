package gus06.entity.gus.sys.expression1.apply.opsrc;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160814";}


	private Service findSrc;

	public EntityImpl() throws Exception
	{
		findSrc = Outside.service(this,"gus.app.jarfile.entity.findsrc");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String op = (String) obj;
		String entityName = "gus.sys.expression1.apply.op."+op;
		return findSrc.t(entityName);
	}
}