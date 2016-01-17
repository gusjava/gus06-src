package gus06.entity.gus.app.jarfile.listing.entities.filter.st;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141112";}


	private Service listFilter;
	private Service listing;
	private Service filterBuilder;


	public EntityImpl() throws Exception
	{
		listFilter = Outside.service(this,"gus.list.findall");
		listing = Outside.service(this,"gus.app.jarfile.listing.entities");
		filterBuilder = Outside.service(this,"gus.filter.string.build.startswith");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		List list = (List) listing.g();
		
		F filter = (F) filterBuilder.t(s);
		return listFilter.t(new Object[]{list,filter});
	}
}
