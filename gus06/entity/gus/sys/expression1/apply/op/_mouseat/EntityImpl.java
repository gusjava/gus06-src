package gus06.entity.gus.sys.expression1.apply.op._mouseat;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160419";}


	private Service mouseOrder;
	
	public EntityImpl() throws Exception
	{mouseOrder = Outside.service(this,"gus.awt.robot.mouse.order");}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new E1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class E1 implements E
	{
		private String infos;
		
		public E1(String infos)
		{this.infos = infos;}
		
		public void e() throws Exception
		{
			mouseOrder.p("position "+infos);
		}
	}
}
