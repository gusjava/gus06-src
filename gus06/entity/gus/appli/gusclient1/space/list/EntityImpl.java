package gus06.entity.gus.appli.gusclient1.space.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140719";}

	public static final String KEY = "space.list";

	private Map prop;
	private List list;
	
	
	public EntityImpl() throws Exception
	{
		prop = (Map) Outside.resource(this,"prop");
	}
	
	
	public Object g() throws Exception
	{
		if(list==null) init();
		return list;
	}
	
	
	
	private void init()
	{
		list = new ArrayList();
		if(!prop.containsKey(KEY)) return;
		String value = (String) prop.get(KEY);
		String[] n = value.split(";");
		for(String s:n) list.add(s);
	}
}
