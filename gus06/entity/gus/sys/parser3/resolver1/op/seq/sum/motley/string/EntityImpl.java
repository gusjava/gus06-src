package gus06.entity.gus.sys.parser3.resolver1.op.seq.sum.motley.string;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		StringBuffer b = new StringBuffer();
		for(Object o:oo) b.append(toString(o));
		return b.toString();
	}
	
	private String toString(Object o) throws Exception
	{
		if(o==null) return "null";
		
		String s = o.toString();
		String h = Integer.toHexString(o.hashCode());
		
		if(s.endsWith("@"+h)) throw new Exception("Object not compatible with String: "+o);
		return s;
	}
}
