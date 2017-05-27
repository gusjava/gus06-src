package gus06.entity.gus.sys.parser3.resolver1.op.seq.sum.motley.date;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170413";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.time.date.add.days");
	}



	public Object t(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		Date date = (Date) oo[0];
		
		int nb = buildInt(oo);
		return perform.t(new Object[]{date,new Integer(nb)});
	}
	
	
	private int buildInt(Object[] oo) throws Exception
	{
		int sum = 0;
		for(int i=1;i<oo.length;i++) sum += toInt(oo[i]);
		return sum;
	}
	
	private int toInt(Object obj) throws Exception
	{
		if(obj instanceof Integer) return ((Integer) obj).intValue();
		if(obj instanceof Long) return ((Long) obj).intValue();
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
