package gus06.entity.gus.dir.listing.dirtopathmap.forext.gus;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170401";}
	
	public static final String EXT = "gus";


	private Service find;

	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.dir.listing.dirtopathmap.forext");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
        	return find.t(new Object[]{dir,EXT});
	}
}
