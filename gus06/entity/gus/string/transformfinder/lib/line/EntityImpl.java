package gus06.entity.gus.string.transformfinder.lib.line;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150927";}
	
	public static final String OFFSET = "line_";

	
	
	private Map map;
	
	private void put(String key, Service s)
	{map.put(OFFSET+key,s);}
	
	
	
	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("count",Outside.service(this,"gus.string.transform.line.count"));
		put("count_distinct",Outside.service(this,"gus.string.transform.line.count.distinct"));
		put("count_empty",Outside.service(this,"gus.string.transform.line.count.empty"));
		put("count_notempty",Outside.service(this,"gus.string.transform.line.count.notempty"));
		
		put("display_index",Outside.service(this,"gus.string.transform.line.display.index"));
		put("display_length",Outside.service(this,"gus.string.transform.line.display.length"));
		put("display_occ",Outside.service(this,"gus.string.transform.line.display.occ"));
		
		put("dup_all",Outside.service(this,"gus.string.transform.line.duplicate.all"));
		put("dup_first",Outside.service(this,"gus.string.transform.line.duplicate.first"));
		put("dup_last",Outside.service(this,"gus.string.transform.line.duplicate.last"));
		
		put("each_distinct",Outside.service(this,"gus.string.transform.line.each.distinct"));
		put("each_same",Outside.service(this,"gus.string.transform.line.each.same"));
		put("each_samelength",Outside.service(this,"gus.string.transform.line.each.samelength"));
		
		put("invert",Outside.service(this,"gus.string.transform.line.order.invert"));
		put("permute",Outside.service(this,"gus.string.transform.line.order.permute"));
		put("permute_inv",Outside.service(this,"gus.string.transform.line.order.permute.inv"));
		put("shuffle",Outside.service(this,"gus.string.transform.line.order.shuffle"));
		put("sort",Outside.service(this,"gus.string.transform.line.order.sort"));
		put("sortlength",Outside.service(this,"gus.string.transform.line.order.sortlength"));
		put("sortnum",Outside.service(this,"gus.string.transform.line.order.sortnum"));
		
		put("rm_doubloon",Outside.service(this,"gus.string.transform.line.remove.doubloon"));
		put("rm_empty",Outside.service(this,"gus.string.transform.line.remove.empty"));
		put("rm_empty2",Outside.service(this,"gus.string.transform.line.remove.empty.multi"));
		put("rm_first",Outside.service(this,"gus.string.transform.line.remove.first"));
		put("rm_last",Outside.service(this,"gus.string.transform.line.remove.last"));
		
		put("length_max",Outside.service(this,"gus.string.transform.line.length.max"));
		put("length_min",Outside.service(this,"gus.string.transform.line.length.min"));
		put("length_sum",Outside.service(this,"gus.string.transform.line.length.sum"));
		put("length_avg",Outside.service(this,"gus.string.transform.line.length.avg"));
		put("length_variance",Outside.service(this,"gus.string.transform.line.length.variance"));
		put("length_toseq",Outside.service(this,"gus.string.transform.line.length.tosequence"));
		
		put("trim",Outside.service(this,"gus.string.transform.line.trim"));
		put("normalize",Outside.service(this,"gus.string.transform.line.normalize"));
	}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(map.containsKey(s)) return map.get(s);
		return null;
	}
	
	public Object g() throws Exception
	{return map;}
}
