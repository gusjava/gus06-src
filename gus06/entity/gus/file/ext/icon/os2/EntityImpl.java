package gus06.entity.gus.file.ext.icon.os2;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140807";}

	private Service extToIcon;

	public EntityImpl() throws Exception
	{extToIcon = Outside.service(this,"gus.file.ext.icon.os");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String ext = getExtension((String) obj);
		return extToIcon.t(ext);
	}
	
	
	private String getExtension(String name)
	{
		if(name.endsWith("\\") || name.endsWith("/")) return "#";
		if(!name.contains(".")) return "";
		
		String[] n = name.split("\\."); 
		return n[n.length-1];
	}
}
