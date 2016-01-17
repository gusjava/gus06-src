package gus06.entity.gus.crypto.pbe.stringcol.decrypt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150613";}

	private Service decrypt;

	public EntityImpl() throws Exception
	{decrypt = Outside.service(this,"gus.crypto.pbe.string.decrypt");}

	
	
	public Object t(Object obj) throws Exception
	{
		T t = (T) decrypt.t(obj);
		return new Decrypter(t);
	}
	
	
	
	private class Decrypter implements T
	{
		private T t;
		public Decrypter(T t) {this.t = t;}

		private String de(String input) throws Exception
		{return (String) t.t(input);}

		public Object t(Object obj) throws Exception
		{
			if(obj instanceof String) return de((String)obj);
			if(obj instanceof Map) return decrypt_map((Map)obj);
			if(obj instanceof List) return decrypt_list((List)obj);
			if(obj instanceof Set) return decrypt_set((Set)obj);

			throw new Exception("invalid input data type: "+obj.getClass().getName());
		}

		private Map decrypt_map(Map map) throws Exception
		{
			Properties map1 = new Properties();
			Iterator it = map.keySet().iterator();
			while(it.hasNext())
			{
				String key = (String) it.next();
				String value = (String) map.get(key);
				map1.setProperty(de(key),de(value));
			}
			return map1;
		}

		private List decrypt_list(List list) throws Exception
		{
			ArrayList list1 = new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				String value = (String) list.get(i);
				list1.add(de(value));
			}
			return list1;
		}

		private Set decrypt_set(Set set) throws Exception
		{
			HashSet set1 = new HashSet();
			Iterator it = set.iterator();
			while(it.hasNext())
			{
				String value = (String) it.next();
				set1.add(de(value));
			}
			return set1;
		}
	}
}
