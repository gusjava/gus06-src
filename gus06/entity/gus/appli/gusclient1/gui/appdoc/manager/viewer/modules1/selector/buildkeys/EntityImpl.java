package gus06.entity.gus.appli.gusclient1.gui.appdoc.manager.viewer.modules1.selector.buildkeys;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140830";}

	private Service findList;
	private Service listFilter;
	
	private List keys;


	public EntityImpl() throws Exception
	{
		findList = Outside.service(this,"gus.app.jarfile.listing.java.manager.gyem.modules");
		listFilter = Outside.service(this,"gus.list.filter.rule.one");
		keys = (List) findList.g();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		return listFilter.t(new Object[]{keys,rule});
	}
}
