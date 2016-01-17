package gus06.entity.gus.map.deep.put;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150905";}
	
	public static final String MODE_REPLACE = "replace";
	public static final String MODE_CHANGE = "change";
	public static final String MODE_APPEND = "append";
	


	private Service remove;
	private Service replace;
	private Service empty;
	private Service change;
	private Service append;


	public EntityImpl() throws Exception
	{
		remove = Outside.service(this,"gus.map.deep.put.remove");
		replace = Outside.service(this,"gus.map.deep.put.replace");
		empty = Outside.service(this,"gus.map.deep.put.empty");
		change = Outside.service(this,"gus.map.deep.put.change");
		append = Outside.service(this,"gus.map.deep.put.append");
	}


	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		
		if(o.length==4)	{handleMain(o[0],(String) o[1],o[2],(String) o[3]);return;}
		if(o.length==3)	{handleReplace(o[0],(String) o[1],o[2]);return;}
		
		throw new Exception("Wrong data number: "+o.length);
	}
	
	
	private void handleMain(Object data, String key, Object value, String mode) throws Exception
	{
		if(mode.equals(MODE_REPLACE)) {handleReplace(data,key,value);return;}
		if(mode.equals(MODE_CHANGE)) {handleChange(data,key,value);return;}
		if(mode.equals(MODE_APPEND)) {handleAppend(data,key,value);return;}
		
		throw new Exception("Invalid mode: "+mode);
	}
	
	
	private void handleReplace(Object data, String key, Object value) throws Exception
	{
		if(value==null)
			remove.p(new Object[]{data,key});
		else replace.p(new Object[]{data,key,value});
	}
	
	
	private void handleChange(Object data, String key, Object value) throws Exception
	{
		if(value==null)
			empty.p(new Object[]{data,key});
		else change.p(new Object[]{data,key,value});
	}
	
	
	private void handleAppend(Object data, String key, Object value) throws Exception
	{
		if(value==null) return;
		append.p(new Object[]{data,key,value});
	}
}
