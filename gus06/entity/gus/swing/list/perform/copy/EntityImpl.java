package gus06.entity.gus.swing.list.perform.copy;

import gus06.framework.*;
import javax.swing.JList;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160603";}


	private Service clipboardAccess;
	private Service jlistToString;


	public EntityImpl() throws Exception
	{
		clipboardAccess = Outside.service(this,"gus.clipboard.access.string");
		jlistToString = Outside.service(this,"gus.tostring.jlist");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JList list = (JList) obj;
		String s = (String) jlistToString.t(list);
		clipboardAccess.p(s);
	}
}
