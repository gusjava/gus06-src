package gus06.entity.gus.sys.expression1.apply.op._formatdate;

import gus06.framework.*;
import java.util.Date;
import java.text.DateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161120";}
	
	
	private Service toDateFormat;
	
	public EntityImpl() throws Exception
	{
		toDateFormat = Outside.service(this,"gus.find.dateformat");
	}	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Date) return new T1((Date) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private Date date;
		
		public T1(Date date)
		{this.date = date;}
		
		public Object t(Object obj) throws Exception
		{
			DateFormat df = (DateFormat) toDateFormat.t(obj);
			return df.format(date);
		}
	}
}
