package gus06.entity.gus.sys.xhtmlparser1.analyze2.buildparams;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170226";}
	
	public static final Pattern P = Pattern.compile("([^= \\t\\n]+)[ \\t\\n]*=[ \\t\\n]*\"([^\"]*)\"",Pattern.DOTALL);

	
	
	public Object t(Object obj) throws Exception
	{
		String params = (String) obj;
		Map map = new HashMap();
		if(params==null) return map;
		
		Matcher m = P.matcher(params);
		while(m.find())
		{
			String key = m.group(1);
			String value = m.group(2);
			
			if(map.containsKey(key))
			{
				String value0 = (String) map.get(key);
				map.put(key,value0.trim()+" "+value.trim());
			}
			else map.put(key,value);
		}
		return map;
	}
}
