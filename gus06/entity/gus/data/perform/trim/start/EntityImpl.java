package gus06.entity.gus.data.perform.trim.start;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170201";}


	private Service performString;
	private Service performList;
	private Service performArray;
	
	public EntityImpl() throws Exception
	{
		performString = Outside.service(this,"gus.string.transform.str.trim.start");
		performList = Outside.service(this,"gus.list.trim.start");
		performArray = Outside.service(this,"gus.array.trim.start");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List) return performList.t(obj);
		if(obj instanceof Object[]) return performArray.t(obj);
		if(obj instanceof String) return performString.t(obj);
		if(obj instanceof Number) return performString.t(""+obj);
		if(obj instanceof Boolean) return performString.t(""+obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
