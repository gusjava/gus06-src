package gus06.entity.gus.string.extract.match.last;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170328";}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String text = (String) o[0];
		Pattern p = (Pattern) o[1];
		
		Matcher m = p.matcher(text);
		
		String result = null;
		while(m.find()) result = m.group();
		return result;
	}
}
