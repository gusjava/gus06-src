package gus06.entity.gus.env.windows.command.lock;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150921";}


	public void e() throws Exception
	{
		Runtime.getRuntime().exec("rundll32.exe user32.dll, LockWorkStation");
	}
}
