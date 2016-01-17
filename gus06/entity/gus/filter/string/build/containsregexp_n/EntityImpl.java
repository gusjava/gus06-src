package gus06.entity.gus.filter.string.build.containsregexp_n;

import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}
	
	
	private Service charNormalize;
	
	public EntityImpl() throws Exception
	{charNormalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}
	
	
	private String normalize(String s) throws Exception
	{return (String) charNormalize.t(s);}
	
	
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
			String str = normalize(obj.toString());
			return p.matcher(str).find();
		}
	}
}
