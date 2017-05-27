package gus06.entity.gus.filter.string.build.mstars2_i;

import gus06.framework.*;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161202";}


	private Service buildRegex;

	public EntityImpl() throws Exception
	{
		buildRegex = Outside.service(this,"gus.filter.string.build.mstars2.regex");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		String s = ((String) obj).toLowerCase();
		return new Filter(s);
	}
	
	
	private class Filter implements F
	{
		private Pattern p;
		public Filter(String s) throws Exception
		{
			String regexp = (String) buildRegex.t(s);
			p = Pattern.compile(regexp, Pattern.DOTALL);
		}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = ((String) obj).toLowerCase();
			return p.matcher(str).matches();
		}
	}
}
