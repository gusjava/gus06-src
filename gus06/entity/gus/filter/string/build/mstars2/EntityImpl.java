package gus06.entity.gus.filter.string.build.mstars2;

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
	{return new Filter((String) obj);}
	
	
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
			String str = (String) obj;
			return p.matcher(str).matches();
		}
	}
}
