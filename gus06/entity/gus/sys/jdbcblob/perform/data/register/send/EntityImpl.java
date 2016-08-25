package gus06.entity.gus.sys.jdbcblob.perform.data.register.send;

import gus06.framework.*;
import java.sql.Connection;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160602";}

	public final static String KEY_ID = "ID";
	public final static String KEY_NAME = "NAME";
	public final static String KEY_TYPE = "TYPE";
	public final static String KEY_SIZE = "SIZE";
	public final static String KEY_PREVIEW = "PREVIEW";
	public final static String KEY_DATA = "DATA";
	
	
	
	private Service formatName;
	private Service formatValue;
	
	public EntityImpl() throws Exception
	{
		formatName = Outside.service(this,"gus.jdbc.mysql.format.sql.name");
		formatValue = Outside.service(this,"gus.jdbc.mysql.format.sql.value");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		Map map = (Map) o[2];
		
		String id = (String) map.get(KEY_ID);
		String name = (String) map.get(KEY_NAME);
		String type = (String) map.get(KEY_TYPE);
		String size = (String) map.get(KEY_SIZE);
		byte[] preview = (byte[]) map.get(KEY_PREVIEW);
		byte[] content = (byte[]) map.get(KEY_DATA);
		
		
		
		
		StringBuffer b = new StringBuffer("UPDATE "+formatName(path)+" SET ");
	}


	private String formatValue(String value) throws Exception
	{return (String) formatValue.t(value);}
	
	private String formatName(String name) throws Exception
	{return (String) formatName.t(name);}
}
