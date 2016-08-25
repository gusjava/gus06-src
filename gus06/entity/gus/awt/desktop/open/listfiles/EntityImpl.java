package gus06.entity.gus.awt.desktop.open.listfiles;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151017";}


	private Service open;
	private Service toList;


	public EntityImpl() throws Exception
	{
		open = Outside.service(this,"gus.awt.desktop.open");
		toList = Outside.service(this,"gus.convert.stringtolist");
	}
	
	
	public void p(Object obj) throws Exception
	{
		List list = toList(obj);
		for(int i=0;i<list.size();i++)
		open.p(list.get(i));
	}
	
	
	
	private List toList(Object obj) throws Exception
	{
		if(obj instanceof List) return (List) obj;
		if(obj instanceof String) return (List) toList.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
