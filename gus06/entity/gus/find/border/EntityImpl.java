package gus06.entity.gus.find.border;

import gus06.framework.*;
import javax.swing.border.Border;
import java.util.Map;
import javax.swing.BorderFactory;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service stringToBorder;
	private Service intArrayToBorder;
	private Service mapToBorder;

	public EntityImpl() throws Exception
	{
		stringToBorder = Outside.service(this,"gus.convert.stringtoborder");
		intArrayToBorder = Outside.service(this,"gus.convert.intarraytoborder");
		mapToBorder = Outside.service(this,"gus.convert.maptoborder");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Border) return obj;
		
		if(obj instanceof Integer) return integerToBorder((Integer) obj);
		if(obj instanceof String) return stringToBorder.t(obj);
		if(obj instanceof int[]) return intArrayToBorder.t(obj);
		if(obj instanceof Map) return mapToBorder.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Border integerToBorder(Integer n)
	{
		int v = n.intValue();
		return BorderFactory.createEmptyBorder(v,v,v,v);
	}
}
