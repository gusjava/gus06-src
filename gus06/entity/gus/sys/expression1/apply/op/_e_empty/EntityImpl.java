package gus06.entity.gus.sys.expression1.apply.op._e_empty;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import javax.swing.text.JTextComponent;
import java.awt.Container;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151113";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.empty");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map) return new E1(obj);
		if(obj instanceof File) return new E1(obj);
		if(obj instanceof Collection) return new E1(obj);
		if(obj instanceof StringBuffer) return new E1(obj);
		if(obj instanceof JTextComponent) return new E1(obj);
		if(obj instanceof Container) return new E1(obj);
		
		if(obj instanceof Map[]) return new E1(obj);
		if(obj instanceof File[]) return new E1(obj);
		if(obj instanceof Collection[]) return new E1(obj);
		if(obj instanceof StringBuffer[]) return new E1(obj);
		if(obj instanceof JTextComponent[]) return new E1(obj);
		if(obj instanceof Container[]) return new E1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class E1 implements E
	{
		private Object o;
		public E1(Object o) {this.o = o;}
		
		public void e() throws Exception
		{perform.p(o);}
	}
}
