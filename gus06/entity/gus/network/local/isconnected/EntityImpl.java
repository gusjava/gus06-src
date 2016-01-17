package gus06.entity.gus.network.local.isconnected;

import java.net.InetAddress;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150626";}
	
	
	public boolean f(Object obj) throws Exception
	{
		return !InetAddress.getLocalHost().isLoopbackAddress();
	}
}
