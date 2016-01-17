package gus06.entity.gus.network.local.ip;

import java.net.InetAddress;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140706";}
	
	
	public Object g() throws Exception
	{
		return InetAddress.getLocalHost().getHostAddress();
	}
}
