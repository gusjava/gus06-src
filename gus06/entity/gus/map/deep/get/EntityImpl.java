package gus06.entity.gus.map.deep.get;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160223";}


	private Service nextData;

	public EntityImpl() throws Exception
	{nextData = Outside.service(this,"gus.map.deep.nextdata0");}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2)	throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		String key = (String) o[1];
		
		String[] n = key.split("\\.");
		String lastKey = n[n.length-1];
		
		for(int i=0;i<n.length;i++)
		data = nextData(data,n[i]);
		
		return data;
	}
	
	
	private Object nextData(Object data, String key) throws Exception
	{return nextData.t(new Object[]{data,key});}
}
