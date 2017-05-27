package gus06.entity.gus.process.tostring;

import gus06.framework.*;
import java.io.InputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170410";}


	private Service isToString;


	public EntityImpl() throws Exception
	{
		isToString = Outside.service(this,"gus.io.transfer.tostring");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Process proc = (Process) obj;
		InputStream is = proc.getInputStream();
		return isToString.t(is);
	}
}
