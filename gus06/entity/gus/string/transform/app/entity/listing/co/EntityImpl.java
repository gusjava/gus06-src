package gus06.entity.gus.string.transform.app.entity.listing.co;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151024";}


	private Service getListing;
	private Service listToString;


	public EntityImpl() throws Exception
	{
		getListing = Outside.service(this,"gus.app.jarfile.listing.entities.filter.co");
		listToString = Outside.service(this,"gus.tostring.list");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		List list = (List) getListing.t(obj);
		return listToString.t(list);
	}
}
