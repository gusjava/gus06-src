package gus06.entity.gus.sys.filetool.ext.runtask1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150619";}
	
	
	private Service factory;
	
	public EntityImpl() throws Exception
	{factory = Outside.service(this,"factory#gus.sys.filetool.ext.runtask1.holder");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object holder = factory.g();
		((P)holder).p(obj);
		return ((I)holder).i();
	}
}
