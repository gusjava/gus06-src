package gus06.entity.gus.data.handle.object.fromrule;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Date;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20160819";}
	
	
	private Map map;

	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("browse",Outside.service(this,"gus.data.perform.browse"));
		put("clipboard",Outside.service(this,"gus.clipboard.access"));
		put("close",Outside.service(this,"gus.data.perform.close"));
		put("delete",Outside.service(this,"gus.data.perform.delete"));
		put("empty",Outside.service(this,"gus.data.perform.empty"));
		put("exec",Outside.service(this,"gus.data.perform.exec"));
		put("open",Outside.service(this,"gus.data.perform.open"));
		put("permute",Outside.service(this,"gus.data.perform.permute"));
		put("permute_inv",Outside.service(this,"gus.data.perform.permute.inv"));
		put("reverse",Outside.service(this,"gus.data.perform.reverse"));
		put("shuffle",Outside.service(this,"gus.data.perform.shuffle"));
		put("sort",Outside.service(this,"gus.data.perform.sort"));
		put("sort_inv",Outside.service(this,"gus.data.perform.sort.inv"));
		put("sortnum",Outside.service(this,"gus.data.perform.sortnum"));
		put("sortnum_inv",Outside.service(this,"gus.data.perform.sortnum.inv"));
	}
	
	
	public Object r(String key) throws Exception
	{
		if(map.containsKey(key)) return map.get(key);
		return null;
	}
	
	
	private void put(String key, P p)
	{map.put(key,new P_Wrap(p));}
	
	
	
	
	private class P_Wrap implements P
	{
		private P p;
		public P_Wrap(P p) {this.p = p;}
		
		public void p(Object obj) throws Exception
		{p.p(obj);}
	}
}
