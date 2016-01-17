package gus06.entity.gus.sys.script1.context.evaluate.string1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150903";}


	private Service evaluate;
	
	public EntityImpl() throws Exception
	{
		evaluate = Outside.service(this,"gus.sys.script1.context.evaluate");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object eval = evaluate.t(obj);
		return toString(eval);
	}
	
	private String toString(Object r) throws Exception
	{
		if(r==null) return null;
		if(r instanceof String) return (String) r;
		return r.toString();
	}
}
