package gus06.entity.gus.jdbc.connection.builder.infos;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150621";}
	
	public static final String KEY_URL = "url";
	public static final String KEY_USER = "user";
	public static final String KEY_PWD = "pwd";
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof G) return fromG((G) obj);
		if(obj instanceof Map) return fromMap((Map) obj);
		if(obj instanceof List) return fromList((List) obj);
		if(obj instanceof String[]) return fromArray((String[]) obj);
		if(obj instanceof String) return fromString((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	public Map fromG(G g) throws Exception
	{
		Object obj = g.g();
		if(obj instanceof Map) return fromMap((Map) obj);
		if(obj instanceof String[]) return fromArray((String[]) obj);
		if(obj instanceof String) return fromString((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Map fromMap(Map map) throws Exception
	{
		String url = get1(map,KEY_URL);
		String user = get0(map,KEY_USER);
		String pwd = get0(map,KEY_PWD);
		
		return build(url,user,pwd);
	}
	
	private Map fromArray(String[] array) throws Exception
	{
		String url = get1(array,0);
		String user = get0(array,1);
		String pwd = get0(array,2);
		
		return build(url,user,pwd);
	}
	
	private Map fromList(List list) throws Exception
	{
		String url = get1(list,0);
		String user = get0(list,1);
		String pwd = get0(list,2);
		
		return build(url,user,pwd);
	}
	
	private Map fromString(String s) throws Exception
	{
		return fromArray(s.split("\\|",-1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Map build(String url, String user, String pwd)
	{
		if(!url.startsWith("jdbc:")) url = "jdbc:"+url;
		
		Map map = new HashMap();
		map.put(KEY_URL,url);
		if(user!=null && pwd!=null)
		{
			map.put(KEY_USER,user);
			map.put(KEY_PWD,pwd);
		}
		return map;
	}
	
	
	
	
	private String get0(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) return null;
		return (String) map.get(key);
	}
	
	private String get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return (String) map.get(key);
	}
	
	
	
	private String get0(List list, int index) throws Exception
	{
		if(list.size() <= index) return null;
		return (String) list.get(index);
	}
	
	private String get1(List list, int index) throws Exception
	{
		if(list.size() <= index)throw new Exception("Element not found at index: "+index);
		return (String) list.get(index);
	}
	
	
	
	private String get0(String[] array, int index) throws Exception
	{
		if(array.length <= index) return null;
		return array[index];
	}
	
	private String get1(String[] array, int index) throws Exception
	{
		if(array.length <= index) throw new Exception("Element not found at index: "+index);
		return array[index];
	}
}
