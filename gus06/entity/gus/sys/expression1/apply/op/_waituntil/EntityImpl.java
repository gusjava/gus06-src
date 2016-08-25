package gus06.entity.gus.sys.expression1.apply.op._waituntil;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160409";}


	private Service findDate;
	
	public EntityImpl() throws Exception
	{findDate = Outside.service(this,"gus.find.date");}

	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Long) return new E1(toDate(obj));
		if(obj instanceof Date) return new E1(toDate(obj));
		if(obj instanceof String) return new E1(toDate(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Date toDate(Object obj) throws Exception
	{return (Date) findDate.t(obj);}
	
	
	
	private class E1 implements E
	{
		private long t1;
		public E1(Date date){this.t1 = date.getTime();}
		
		public void e() throws Exception
		{
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
