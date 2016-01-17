package gus06.entity.gus.awt.desktop.open.listfiles;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151017";}


	private Service open;


	public EntityImpl() throws Exception
	{
		open = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public void p(Object obj) throws Exception
	{
		List list = (List) obj;
		for(int i=0;i<list.size();i++)
		open.p(list.get(i));
	}
}
