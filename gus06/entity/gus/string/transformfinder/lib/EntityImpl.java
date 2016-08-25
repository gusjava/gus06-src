package gus06.entity.gus.string.transformfinder.lib;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150927";}


	
	private List list;
	
	private void add(Service s)
	{list.add(s);}
	


	public EntityImpl() throws Exception
	{
		list = new ArrayList();
		
		add(Outside.service(this,"gus.string.transformfinder.lib.chardisplay"));
		add(Outside.service(this,"gus.string.transformfinder.lib.charorder"));
		add(Outside.service(this,"gus.string.transformfinder.lib.clipboard"));
		add(Outside.service(this,"gus.string.transformfinder.lib.countchar"));
		add(Outside.service(this,"gus.string.transformfinder.lib.decode"));
		add(Outside.service(this,"gus.string.transformfinder.lib.encode"));
		add(Outside.service(this,"gus.string.transformfinder.lib.entity"));
		add(Outside.service(this,"gus.string.transformfinder.lib.format"));
		add(Outside.service(this,"gus.string.transformfinder.lib.hash"));
		add(Outside.service(this,"gus.string.transformfinder.lib.integer"));
		add(Outside.service(this,"gus.string.transformfinder.lib.jap"));
		add(Outside.service(this,"gus.string.transformfinder.lib.json"));
		add(Outside.service(this,"gus.string.transformfinder.lib.kchar"));
		add(Outside.service(this,"gus.string.transformfinder.lib.kchar2"));
		add(Outside.service(this,"gus.string.transformfinder.lib.line"));
		add(Outside.service(this,"gus.string.transformfinder.lib.norm"));
		add(Outside.service(this,"gus.string.transformfinder.lib.rand"));
		add(Outside.service(this,"gus.string.transformfinder.lib.regexp"));
		add(Outside.service(this,"gus.string.transformfinder.lib.rmchar"));
		add(Outside.service(this,"gus.string.transformfinder.lib.sequence"));
		add(Outside.service(this,"gus.string.transformfinder.lib.split"));
		add(Outside.service(this,"gus.string.transformfinder.lib.str"));
		add(Outside.service(this,"gus.string.transformfinder.lib.timestamp"));
		add(Outside.service(this,"gus.string.transformfinder.lib.truefalse"));
		add(Outside.service(this,"gus.string.transformfinder.lib.truncate"));
		add(Outside.service(this,"gus.string.transformfinder.lib.wrap"));
	}
	
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		for(int i=0;i<list.size();i++)
		{
			T t = (T) list.get(i);
			Object o = t.t(obj);
			if(o!=null) return o;
		}
		return null;
	}
	
	
	public Object g() throws Exception
	{
		Map map = new HashMap();
		for(int i=0;i<list.size();i++)
		{
			G g = (G) list.get(i);
			Map m = (Map) g.g();
			map.putAll(m);
		}
		return map;
	}
}
