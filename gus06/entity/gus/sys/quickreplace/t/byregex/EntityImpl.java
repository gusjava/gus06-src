package gus06.entity.gus.sys.quickreplace.t.byregex;

import gus06.framework.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}

	private Service buildexp;

	public EntityImpl() throws Exception
	{
		buildexp = Outside.service(this,"gus.sys.quickreplace.buildexp");
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
		
            
		String exp = buildexp(selected,del_before,del_after);
		return new ReplaceByRegex(exp,replacement);
	}
	
	private String buildexp(String center, int del_before, int del_after) throws Exception
	{return (String) buildexp.t(new String[]{center,""+del_before,""+del_after});}
	
	
	

	public class ReplaceByRegex implements T
	{
		private String exp;
		private String newExp;

		public ReplaceByRegex(String exp, String newExp)
		{
			this.exp = exp;
			this.newExp = newExp;
		}
		
		public Object t(Object obj) throws Exception
		{
			String text = (String) obj;
			
			Pattern p = Pattern.compile(exp,Pattern.DOTALL);
              		Matcher m = p.matcher(text);
			
			List ranges = new ArrayList();
			while(m.find())
			{
				Integer start = new Integer(m.start());
				Integer end = new Integer(m.end());
				Object[] range = new Object[]{start,end,newExp};
				ranges.add(range);
			}
			return ranges;
		}
	}
}
