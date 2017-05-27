package gus06.entity.gus.jdbc.connection.builder.get;

import gus06.framework.*;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150621";}

	public static final String KEY_URL = "url";
	public static final String KEY_USER = "user";
	public static final String KEY_PWD = "pwd";

	private Service infos;


	public EntityImpl() throws Exception
	{
		infos = Outside.service(this,"gus.jdbc.connection.builder.infos");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) infos.t(obj);
		
		String url = get1(map,KEY_URL);
		String user = get0(map,KEY_USER);
		String pwd = get0(map,KEY_PWD);
		
		return getConnection(url,user,pwd);
	}
	
	
	
	
	private Connection getConnection(String url, String user, String pwd) throws Exception
	{
		try
		{
			if(user==null || user.equals(""))
				return DriverManager.getConnection(url);
			return DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception e)
		{
			String message = "JDBC connection failed for url="+url+" & user="+user;
			throw new Exception(message,e);
		}
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
}
