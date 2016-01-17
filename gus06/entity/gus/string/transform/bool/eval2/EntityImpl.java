package gus06.entity.gus.string.transform.bool.eval2;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141007";}


	private Service eval1;

	public EntityImpl() throws Exception
	{eval1 = Outside.service(this,"gus.string.transform.bool.eval1");}
	

	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(":");
		
		String cond = n[0];
		String v_true = n.length>1?n[1]:"true";
		String v_false = n.length>2?n[2]:"";
		
		return eval1.f(cond)?v_true:v_false;
	}
}
