package gus06.entity.gus.sys.expression1.apply.op._popup_notif;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161005";}
	
	
	private Service manager;
	
	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.sys.popup1.manager");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Map) return new E1((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class E1 implements E
	{
		private Map map;
		public E1(Map map)
		{this.map = map;}
		
		public void e() throws Exception
		{manager.p(map);}
	}
}
