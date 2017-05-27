package gus06.entity.gus.sys.expression1.apply.op._holder_dnd_g;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161016";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.buildholder.dnd.g");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof JComponent) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
