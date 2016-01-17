package gus06.entity.gus.sys.script1.context.evaluate.long1;

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
		return toLong(eval);
	}
	
	private Long toLong(Object r)
	{
		if(r==null) return null;
		if(r instanceof Long) return (Long) r;
		return new Long(r.toString());
	}
}
