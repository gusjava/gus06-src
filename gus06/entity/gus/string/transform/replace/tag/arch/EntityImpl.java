package gus06.entity.gus.string.transform.replace.tag.arch;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150607";}


	private Service checkArch;
		
	public EntityImpl() throws Exception
	{
		checkArch = Outside.service(this,"gus.env.archcheck");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		String arch = (String) checkArch.g();
		
		return text.replace("<arch>",arch);
	}
}
