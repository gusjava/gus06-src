package gus06.entity.gus.filter.string.build.containsregexp_i;

import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}
	
	
	public Object t(Object obj) throws Exception
	{return new F_containsregexp((String)obj);}
	
	
	
	
	private class F_containsregexp implements F
	{
		private Pattern p;
		public F_containsregexp(String regexp)
		{p = Pattern.compile(regexp, Pattern.DOTALL);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = obj.toString().toLowerCase();
			return p.matcher(str).find();
		}
	}
}
