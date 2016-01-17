package gus06.entity.gus.find.border;

import gus06.framework.*;
import javax.swing.border.Border;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service stringToBorder;

	public EntityImpl() throws Exception
	{stringToBorder = Outside.service(this,"gus.convert.stringtoborder");}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Border) return obj;
		if(obj instanceof String) return stringToBorder((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Border stringToBorder(String s) throws Exception
	{return (Border) stringToBorder.t(s);}
}
