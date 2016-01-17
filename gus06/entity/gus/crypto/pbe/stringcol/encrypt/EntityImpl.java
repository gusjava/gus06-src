package gus06.entity.gus.crypto.pbe.stringcol.encrypt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}

	private Service encrypt;

	public EntityImpl() throws Exception
	{encrypt = Outside.service(this,"gus.crypto.pbe.string.encrypt");}

	
	
	public Object t(Object obj) throws Exception
	{
		T t = (T) encrypt.t(obj);
		return new Encrypter(t);
	}
	
	
	
	private class Encrypter implements T
	{
		private T t;
		public Encrypter(T t) {this.t = t;}

		private String en(String input) throws Exception
		{return (String) t.t(input);}

		public Object t(Object obj) throws Exception
		{
			if(obj instanceof String) return en((String)obj);
			if(obj instanceof Map) return encrypt_map((Map)obj);
			if(obj instanceof List) return encrypt_list((List)obj);
			if(obj instanceof Set) return encrypt_set((Set)obj);

			throw new Exception("invalid input data type: "+obj.getClass().getName());
		}

		private Map encrypt_map(Map map) throws Exception
		{
			Properties map1 = new Properties();
			Iterator it = map.keySet().iterator();
			while(it.hasNext())
			{
				String key = (String) it.next();
				String value = (String) map.get(key);
				map1.setProperty(en(key),en(value));
			}
			return map1;
		}

		private List encrypt_list(List list) throws Exception
		{
			ArrayList list1 = new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				String value = (String) list.get(i);
				list1.add(en(value));
			}
			return list1;
		}

		private Set encrypt_set(Set set) throws Exception
		{
			HashSet set1 = new HashSet();
			Iterator it = set.iterator();
			while(it.hasNext())
			{
				String value = (String) it.next();
				set1.add(en(value));
			}
			return set1;
		}
	}
}
