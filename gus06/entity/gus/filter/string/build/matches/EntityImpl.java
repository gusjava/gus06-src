package gus06.entity.gus.filter.string.build.matches;

import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	
	
	public Object t(Object obj) throws Exception
	{return new F_matches((String)obj);}
	
	
	private class F_matches implements F
	{
		private Pattern p;
		public F_matches(String regexp)
		{p = Pattern.compile(regexp, Pattern.DOTALL);}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = obj.toString();
			return p.matcher(str).matches();
		}
	}
}
