package gus06.entity.gus.convert.stringtoicon;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service iconProvider;

	public EntityImpl() throws Exception
	{iconProvider = Outside.service(this,"gus.icon.provider");}
	
	public Object t(Object obj) throws Exception
	{return iconProvider.t(obj);}
}
