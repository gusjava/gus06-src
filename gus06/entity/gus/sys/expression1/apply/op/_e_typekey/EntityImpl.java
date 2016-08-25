package gus06.entity.gus.sys.expression1.apply.op._e_typekey;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160418";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.awt.robot.keyboard.order");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return new E1(obj);
		
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
