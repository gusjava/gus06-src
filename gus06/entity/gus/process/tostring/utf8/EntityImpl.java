package gus06.entity.gus.process.tostring.utf8;

import gus06.framework.*;
import java.io.InputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170410";}


	private Service isToString;


	public EntityImpl() throws Exception
	{
		isToString = Outside.service(this,"gus.io.transfer.tostring.utf8");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Process proc = (Process) obj;
		InputStream is = proc.getInputStream();
		return isToString.t(is);
	}
}
