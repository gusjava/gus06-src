package gus06.entity.gus.java.srccode.extract.entity.name;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140827";}

	private Service srcToPackage;
	
	public EntityImpl() throws Exception
	{
		srcToPackage = Outside.service(this,"gus.java.srccode.extract.package1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String packageName = (String) srcToPackage.t(obj);
		if(packageName.startsWith("gus06.entity."))
			return packageName.substring(13);
		return null;
	}
}
