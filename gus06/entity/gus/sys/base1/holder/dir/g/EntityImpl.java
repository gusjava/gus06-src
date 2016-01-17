package gus06.entity.gus.sys.base1.holder.dir.g;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150524";}

	private File dir;
	
	public EntityImpl() throws Exception
	{dir = (File) Outside.resource(this,"defaultdir");}
	
	public Object g() throws Exception
	{return dir;}
}