package gus06.entity.gus.sys.expression1.apply.op._requestfocus;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160915";}


	private Service forceFocus;

	public EntityImpl() throws Exception
	{
		forceFocus = Outside.service(this,"gus.swing.comp.forcefocus.withmouse");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof JComponent) return new E1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class E1 implements E
	{
		private Object o;
		public E1(Object o) {this.o = o;}
		
		public void e() throws Exception
		{forceFocus.p(o);}
	}
}
