package gus06.entity.gus.sys.expression1.apply.op._as_s;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151111";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof S) return new S1((S) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{S.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	private class S1 implements S
	{
		private S s;
		public S1(S s){this.s = s;}
		
		public void addActionListener(ActionListener listener)
		{s.addActionListener(listener);}
		
		public void removeActionListener(ActionListener listener)
		{s.removeActionListener(listener);}
		
		public List listeners()
		{return s.listeners();}
	}
}
