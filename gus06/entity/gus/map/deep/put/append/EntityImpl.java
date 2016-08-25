package gus06.entity.gus.map.deep.put.append;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151204";}

	private Service perform;
	private Service nextData;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.append");
		nextData = Outside.service(this,"gus.map.deep.nextdata0");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3)	throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		String key = (String) o[1];
		Object value = o[2];
		
		String[] n = key.split("\\.");
		
		for(int i=0;i<n.length;i++)
		data = nextData(data,n[i]);
		
		if(data!=null) perform(data,value);
	}
	
	
	private Object nextData(Object data, String key) throws Exception
	{return nextData.t(new Object[]{data,key});}
	
	private void perform(Object data, Object value) throws Exception
	{perform.p(new Object[]{data,value});}
}
