package gus06.entity.gus.app.jarfile.listing.entities.contains;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160711";}


	private Service listing;

	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.app.jarfile.listing.entities");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String s = (String) obj;
		List list = (List) listing.g();
		return list.contains(s);
	}
}
