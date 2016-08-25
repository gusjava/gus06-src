package gus06.entity.gus.sys.clipboard1.g.string;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160604";}


	private Service accessFile;
	private Service accessString;
	
	private Service convertFile;


	public EntityImpl() throws Exception
	{
		accessFile = Outside.service(this,"gus.clipboard.access.file");
		accessString = Outside.service(this,"gus.clipboard.access.string");
		
		convertFile = Outside.service(this,"gus.file.read.string.autodetect");
	}
	
	
	public Object g() throws Exception
	{
		String s = (String) accessString.g();
		if(s!=null) return s;
		
		File file = (File) accessFile.g();
		if(file!=null) return convertFile.t(file);
		
		return null;
	}
}
