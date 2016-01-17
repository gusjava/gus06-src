package gus06.entity.gus.map.deep.put.replace;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151204";}


	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3)	throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		String key = (String) o[1];
		Object value = o[2];
		
		String[] n = key.split("\\.");
		String lastKey = n[n.length-1];
		
		for(int i=0;i<n.length-1;i++)
		data = nextData(data,n[i]);
		
		putValue(data,lastKey,value);
	}
	
	
	
	
	private Object nextData(Object data, String k) throws Exception
	{
		if(data instanceof Map)
		{
			Map m = (Map) data;
			if(!m.containsKey(k)) m.put(k,new HashMap());
			return m.get(k);
		}
		if(data instanceof List)
		{
			List l = (List) data;
			if(k.equals("after"))
			{
				Map m = new HashMap();
				l.add(m);
				return m;
			}
			if(k.equals("before"))
			{
				Map m = new HashMap();
				l.add(0,m);
				return m;
			}
			int index = Integer.parseInt(k);
			if(index<0) index += l.size();
			
			if(index>=0 && index<l.size()) return l.get(index);
			throw new Exception("Index "+index+" out of range for list with size="+l.size());
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
	
	
	
	
	private void putValue(Object data, String k, Object value) throws Exception
	{
		if(data instanceof Map)
		{
			Map m = (Map) data;
			m.put(k,value);
			return;
		}
		if(data instanceof List)
		{
			List l = (List) data;
			if(k.equals("after"))
			{
				l.add(value);
				return;
			}
			if(k.equals("before"))
			{
				l.add(0,value);
				return;
			}
			int index = Integer.parseInt(k);
			if(index<0) index += l.size();
			
			if(index>=0 && index<l.size())
			{l.set(index,value);return;}
			
			throw new Exception("Index "+index+" out of range for list with size="+l.size());
		}
		if(data instanceof V)
		{
			V v = (V) data;
			v.v(k,value);
			return;
		}
		if(data instanceof P)
		{
			P p = (P) data;
			if(k.equals("p")) {p.p(value);return;}
			throw new Exception("p is expected for P object");
		}
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
}
