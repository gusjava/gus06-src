package gus06.entity.gus.filter.string.build.mstars2_n;

import gus06.framework.*;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161202";}



	private Service buildRegex;
	private Service normalize;
	
	public EntityImpl() throws Exception
	{
		normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		buildRegex = Outside.service(this,"gus.filter.string.build.mstars2.regex");
	}

	private String normalize(String s) throws Exception
	{return (String) normalize.t(s);}


	
	
	public Object t(Object obj) throws Exception
	{
		String s = normalize((String) obj);
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
			String str = normalize((String) obj);
			return p.matcher(str).matches();
		}
	}
}
