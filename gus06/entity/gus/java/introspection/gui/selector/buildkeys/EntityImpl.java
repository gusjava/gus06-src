package gus06.entity.gus.java.introspection.gui.selector.buildkeys;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}

	private Service finder;
	private Service filterBuilder;

	public EntityImpl() throws Exception
	{
		finder = Outside.service(this,"gus.java.searchclass.finder");
		filterBuilder = Outside.service(this,"gus.filter.string.simple1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		F filter = (F) filterBuilder.t(rule);
		return finder.t(filter);
	}
}
