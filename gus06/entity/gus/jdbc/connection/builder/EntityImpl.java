package gus06.entity.gus.jdbc.connection.builder;

import gus06.framework.*;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20170207";}

	private Service getCx;
	private Service initWatcher;
	
	private Map cx_watcher;


	public EntityImpl() throws Exception
	{
		getCx = Outside.service(this,"gus.jdbc.connection.builder.get");
		initWatcher = Outside.service(this,"gus.mysql.socketfactory.watcher.init");
		
		cx_watcher = new HashMap();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object watcher = initWatcher.g();
		Object cx = getCx.t(obj);
		cx_watcher.put(cx,watcher);
		
		return cx;
	}
	
	
	public Object g() throws Exception
	{return cx_watcher;}
}
