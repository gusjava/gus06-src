package gus06.entity.gus.appli.gusagent.perform;

import gus06.framework.*;
import java.util.Map;
import java.sql.Connection;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150626";}


	private Service isConnected;
	private Service jdbcInfo;
	private Service findHolder;
	private Service cmd;


	public EntityImpl() throws Exception
	{
		isConnected = Outside.service(this,"gus.network.local.isconnected");
		jdbcInfo = Outside.service(this,"gus.appli.gusagent.jdbc.infoholder");
		findHolder = Outside.service(this,"gus.jdbc.connection.holder");
		cmd = Outside.service(this,"gus.sys.cmd1.engine");
	}
	
	
	public void e() throws Exception
	{
		if(!isConnected.f(null)) return;
		
		G holder = (G) findHolder.t(jdbcInfo);
		Connection cx = (Connection) holder.g();
		
		cmd.p("beep");
	}
}
