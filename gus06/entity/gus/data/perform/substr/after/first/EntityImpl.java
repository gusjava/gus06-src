package gus06.entity.gus.data.perform.substr.after.first;

import gus06.framework.*;
import java.util.List;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160712";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		String cut = (String) o[1];
		
		if(input instanceof String)
		return substr((String) input,cut);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	private String substr(String s, String cut)
	{
		String[] n = s.split(Pattern.quote(cut),2);
		if(n.length<2) return null;
		return n[1];
	}
}
