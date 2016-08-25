package gus06.entity.gus.collection.comparator.numerical1.inv.sort;

import gus06.framework.*;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Arrays;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160804";}


	private Service findComparator;
	private Comparator comparator;


	public EntityImpl() throws Exception
	{
		findComparator = Outside.service(this,"gus.collection.comparator.numerical1.inv");
		comparator = (Comparator) findComparator.g();
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof List)
		{
			Collections.sort((List) obj,comparator);
			return;
		}
		if(obj instanceof Object[])
		{
			Arrays.sort((Object[])obj,comparator);
			return;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
