package gus06.entity.gus.sys.runtask1.input.file.listing;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150921";}

	public static final String ENTITYSTART = "gus.file.runtask.";
	
	
	private Service entityListing;
	private List list;
	

	public EntityImpl() throws Exception
	{
		entityListing = Outside.service(this,"gus.app.jarfile.listing.entities.filter.st");
		list = (List) entityListing.t(ENTITYSTART);
	}
	
	public Object g() throws Exception
	{return list;}
}
