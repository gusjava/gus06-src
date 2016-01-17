package gus06.entity.gus.appli.gusclient1.gui.appdoc.entities.viewer.selector.buildkeys;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140828";}

	private Service listing;
	private Service listFilter;

	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.app.jarfile.listing.entities");
		listFilter = Outside.service(this,"gus.list.filter2");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		List list = (List) listing.g();
		return listFilter.t(new Object[]{list,rule});
	}
}
