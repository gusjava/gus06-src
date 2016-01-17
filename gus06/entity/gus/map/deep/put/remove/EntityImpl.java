package gus06.entity.gus.map.deep.put.remove;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151204";}


	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2)	throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		String key = (String) o[1];
		
		String[] n = key.split("\\.");
		String lastKey = n[n.length-1];
		
		for(int i=0;i<n.length-1;i++)
		data = nextData(data,n[i]);
		
		if(data!=null) removeValue(data,lastKey);
	}
	
	
	
	
	private Object nextData(Object data, String k) throws Exception
	{
		if(data==null) return null;
		
		if(data instanceof Map)
		{
			Map m = (Map) data;
			if(!m.containsKey(k)) return null;
			return m.get(k);
		}
		if(data instanceof List)
		{
			List l = (List) data;
			int index = Integer.parseInt(k);
			if(index<0) index += l.size();
			
			if(index<0) return null;
			if(index>=l.size()) return null;
			return l.get(index);
		}
		if(data instanceof R)
		{
			R r = (R) data;
			return r.r(k);
		}
		if(data instanceof G)
		{
			G g = (G) data;
			if(k.equals("g")) return g.g();
			throw new Exception("g is expected for G object");
		}
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	
	
	
	private void removeValue(Object data, String k) throws Exception
	{
		if(data instanceof Map)
		{
			Map m = (Map) data;
			if(m.containsKey(k)) m.remove(k);
			return;
		}
		if(data instanceof List)
		{
			List l = (List) data;
			
			int index = Integer.parseInt(k);
			if(index<0) index += l.size();
			
			if(index>=0 && index<l.size()) l.remove(index);
			return;
		}
		if(data instanceof V)
		{
			V v = (V) data;
			v.v(k,null);
			return;
		}
		if(data instanceof P)
		{
			P p = (P) data;
			if(k.equals("p")) p.p(null);
			return;
		}
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
}
