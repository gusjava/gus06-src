package gus06.entity.gus.sys.script1.context.evaluate.integer1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150902";}


	private Service evaluate;
	
	public EntityImpl() throws Exception
	{
		evaluate = Outside.service(this,"gus.sys.script1.context.evaluate");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object eval = evaluate.t(obj);
		return toInteger(eval);
	}
	
	private Integer toInteger(Object r)
	{
		if(r==null) return null;
		if(r instanceof Integer) return (Integer) r;
		return new Integer(r.toString());
	}
}
