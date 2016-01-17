package gus06.entity.gus.app.entity.checkname;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140828";}

	private Service findListing;

	public EntityImpl() throws Exception
	{
		findListing = Outside.service(this,"gus.app.entity.listing");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String name = (String) obj;
		List listing = (List) findListing.g();
		return listing.contains(name);
	}
}
