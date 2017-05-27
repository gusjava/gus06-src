package gus06.entity.gus.data.perform.shuffle;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151124";}


	private Service performSb;
	private Service performIntArray;
	private Service performDoubleArray;
	private Service performObjArray;
	private Service performList;
	
	public EntityImpl() throws Exception
	{
		performSb = Outside.service(this,"gus.data.string.shuffle.perform");
		performIntArray = Outside.service(this,"gus.math.tabint.shuffle.fisher.yates");
		performDoubleArray = Outside.service(this,"gus.math.tabdouble.shuffle.fisher.yates");
		performObjArray = Outside.service(this,"gus.array.objectarray.shuffle");
		performList = Outside.service(this,"gus.list.shuffle");
	}

	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof StringBuffer)
		{performSb.p(obj);return;}
		
		if(obj instanceof int[])
		{performIntArray.p(obj);return;}
		
		if(obj instanceof double[])
		{performDoubleArray.p(obj);return;}
		
		if(obj instanceof Object[])
		{performObjArray.p(obj);return;}
		
		if(obj instanceof List)
		{performList.p(obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
