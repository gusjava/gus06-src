package gus06.entity.gus.data.perform.split;

import gus06.framework.*;
import java.util.List;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		String cut = (String) o[1];
		
		if(input instanceof String)
		return split((String) input,cut);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	private String[] split(String s, String cut)
	{
		return s.split(Pattern.quote(cut),-1);
	}
}
