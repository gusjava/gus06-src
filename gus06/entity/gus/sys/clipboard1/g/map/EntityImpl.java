package gus06.entity.gus.sys.clipboard1.g.map;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160603";}


	private Service accessFile;
	private Service accessString;
	
	private Service convertFile;
	private Service convertString;


	public EntityImpl() throws Exception
	{
		accessFile = Outside.service(this,"gus.clipboard.access.file");
		accessString = Outside.service(this,"gus.clipboard.access.string");
		
		convertFile = Outside.service(this,"gus.file.read.properties.generic");
		convertString = Outside.service(this,"gus.convert.stringtomap");
	}
	
	
	public Object g() throws Exception
	{
		File file = (File) accessFile.g();
		if(file!=null) return convertFile.t(file);
		
		String s = (String) accessString.g();
		if(s!=null) return convertString.t(s);
		
		return null;
	}
}
