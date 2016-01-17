package gus06.entity.gus.entitydev.check.dependencies;

import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150823";}


	private Service retrieve;


	public EntityImpl() throws Exception
	{
		retrieve = Outside.service(this,"gus.entitydev.retrieve.dependencies");
	}
	
	public boolean f(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set set = (Set) retrieve.t(o[0]);
		return set.contains(o[1]);
	}
}