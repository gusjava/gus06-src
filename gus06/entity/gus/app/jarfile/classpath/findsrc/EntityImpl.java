package gus06.entity.gus.app.jarfile.classpath.findsrc;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140829";}


	private Service entryToSrc;

	
	public EntityImpl() throws Exception
	{
		entryToSrc = Outside.service(this,"gus.app.jarfile.entryname.findsrc");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "";
		
		String classPath = (String) obj;
		String entryName = classPath.replace(".","/")+".java";
		return entryToSrc.t(entryName);
	}
}
