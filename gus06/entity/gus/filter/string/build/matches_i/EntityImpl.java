package gus06.entity.gus.filter.string.build.matches_i;

import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	
	
	public Object t(Object obj) throws Exception
	{
		String s = ((String) obj).toLowerCase();
		return new Filter(s);
	}
	
	
	private class Filter implements F
	{
		private Pattern p;
		public Filter(String regexp)
		{p = Pattern.compile(regexp, Pattern.DOTALL);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = ((String) obj).toLowerCase();
			
			return p.matcher(str).matches();
		}
	}
}
