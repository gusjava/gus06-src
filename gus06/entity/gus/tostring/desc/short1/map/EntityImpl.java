package gus06.entity.gus.tostring.desc.short1.map;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}



	public Object t(Object obj) throws Exception
	{
		Map m = (Map) obj;
		return className(m)+" ["+m.size()+"]";
	}
	
	private String className(Object obj)
	{return obj.getClass().getSimpleName();}
}
