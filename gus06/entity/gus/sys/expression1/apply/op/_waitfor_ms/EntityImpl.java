package gus06.entity.gus.sys.expression1.apply.op._waitfor_ms;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160407";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Long) return new E1(toLong(obj));
		if(obj instanceof Integer) return new E1(toLong(obj));
		if(obj instanceof String) return new E1(toLong(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
	
	
	
	private class E1 implements E
	{
		private long d;
		public E1(long d){this.d = d;}
		
		public void e() throws Exception
		{
			long t0 = System.currentTimeMillis();
			long t1 = t0+d;
			
			while(System.currentTimeMillis()<t1)
			{sleep_1();}
		}
	}
	
	
	private void sleep_1()
	{
		try{Thread.sleep(1);}
		catch(Exception e)
		{Outside.err(this,"sleep_1()",e);}
	}
}