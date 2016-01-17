package gus06.entity.gus.map.deep.put.change;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151204";}

	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.change");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3)	throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		String key = (String) o[1];
		Object value = o[2];
		
		String[] n = key.split("\\.");
		
		for(int i=0;i<n.length;i++)
		data = nextData(data,n[i]);
		
		perform.p(new Object[]{data,value});
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
}