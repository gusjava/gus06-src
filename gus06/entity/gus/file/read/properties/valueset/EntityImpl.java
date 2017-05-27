package gus06.entity.gus.file.read.properties.valueset;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import gus06.framework.*;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170327";}
	
	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f==null || !f.isFile()) return null;
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(f);
		p.load(fis);
		fis.close();
		return new HashSet(p.values());
	}
}
