package gus06.entity.gus.sys.expression1.apply.op._mouseclick;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160418";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.awt.robot.mouse.order");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return new E1((String) obj);
		if(obj instanceof Integer) return new E1(""+obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class E1 implements E
	{
		private String s;
		public E1(String s) {this.s = s.toLowerCase();}
		
		public void e() throws Exception
		{
			if(s.equals("right")) {perform.p("clickright");return;}
			if(s.equals("left")) {perform.p("clickleft");return;}
			
			if(s.equals("1")) {perform.p("clickright");return;}
			if(s.equals("2")) {perform.p("clickleft");return;}
			
			perform.p("clickright");
		}
	}
}
