package gus06.entity.gus.sys.quickreplace.t.byregex.smart;

import gus06.framework.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}

	private Service buildexp;
	private Service titled;

	public EntityImpl() throws Exception
	{
		buildexp = Outside.service(this,"gus.sys.quickreplace.buildexp");
		titled = Outside.service(this,"gus.string.transform.str.titled");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String[] o1 = (String[]) o[0];
		int[] o2 = (int[]) o[1];
		
		String textMem = o1[0];
		String selected = o1[1];
		String replacement = o1[2];
		
		int position = o2[0];
		int del_before = o2[1];
		int del_after = o2[2];
		
		Map map = new HashMap();
		
		addToMap(map,selected,replacement);
		addToMap(map,titled(selected),titled(replacement));
		addToMap(map,upper(selected),upper(replacement));
		addToMap(map,lower(selected),lower(replacement));
            
		return new ReplaceByRegex(map,del_before,del_after);
	}
	
	
	
	private void addToMap(Map map, String key, String value)
	{if(!map.containsKey(key)) map.put(key,value);}
	
	private String titled(String s) throws Exception
	{return (String) titled.t(s);}
	
	private String upper(String s)
	{return s.toUpperCase();}
	
	private String lower(String s)
	{return s.toLowerCase();}
	
	
	
	private String buildexp(String center, int del_before, int del_after) throws Exception
	{return (String) buildexp.t(new String[]{center,""+del_before,""+del_after});}
	
	
	
	
	

	public class ReplaceByRegex implements T
	{
		private Map map;
		private int del_before;
		private int del_after;

		public ReplaceByRegex(Map map, int del_before, int del_after)
		{
			this.map = map;
			this.del_before = del_before;
			this.del_after = del_after;
		}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			Map map1 = new HashMap();
			
			Iterator it = map.keySet().iterator();
			while(it.hasNext())
			{
				String key = (String) it.next();
				String value = (String) map.get(key);
				
				String exp = buildexp(key,del_before,del_after);
				
				Pattern p = Pattern.compile(exp,Pattern.DOTALL);
              			Matcher m = p.matcher(text);
				
				while(m.find())
				{
					Integer start = new Integer(m.start());
					Integer end = new Integer(m.end());
					Object[] range = new Object[]{start,end,value};
					map1.put(start,range);
				}
			}
			
			List ranges = new ArrayList();
			
			List keys = new ArrayList(map1.keySet());
			Collections.sort(keys);
			
			for(int i=0;i<keys.size();i++)
			{
				Integer key = (Integer) keys.get(i);
				Object[] range = (Object[]) map1.get(key);
				ranges.add(range);
			}
			return ranges;
		}
	}
}
