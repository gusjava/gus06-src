package gus06.entity.gus.sys.parser3.resolver1.op.binary.sup2;

import gus06.framework.*;
import java.util.List;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	private Service stringToDate;
	
	public EntityImpl() throws Exception
	{
		stringToDate = Outside.service(this,"gus.convert.stringtodate");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List cut = (List) o[0];
		T t = (T) o[1];
		
		if(cut.size()!=2) throw new Exception("Invalid split for equals operation: "+cut.size());
		
		Object o1 = t.t(cut.get(0));
		Object o2 = t.t(cut.get(1));
		
		if(o1==null) return Boolean.FALSE;
		if(o2==null) return Boolean.FALSE;
		
		if(o1 instanceof Number && o2 instanceof Number)
			return new Boolean(numberToDouble(o1) > numberToDouble(o2));
		
		if(o1 instanceof Date && o2 instanceof Date)
			return new Boolean(dateToLong(o1) > dateToLong(o2));
		
		if(o1 instanceof Date && o2 instanceof String)
			return new Boolean(dateToLong(o1) > strDateToLong(o2));
		
		if(o1 instanceof String && o2 instanceof Date)
			return new Boolean(strDateToLong(o1) > dateToLong(o2));
		
		if(o1 instanceof String && o2 instanceof String)
			return new Boolean(((String) o1).compareTo((String) o2) > 0);
		
		return Boolean.FALSE;
	}
	
	
	private double numberToDouble(Object obj)
	{return ((Number) obj).doubleValue();}
	
	private long dateToLong(Object obj)
	{return ((Date) obj).getTime();}
	
	private long strDateToLong(Object obj) throws Exception
	{return ((Date) stringToDate.t(obj)).getTime();}
}
