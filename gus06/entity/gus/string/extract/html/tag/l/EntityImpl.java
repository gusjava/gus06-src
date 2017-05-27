package gus06.entity.gus.string.extract.html.tag.l;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170117";}

	private Pattern p;

	public EntityImpl() throws Exception
	{
		p = Pattern.compile("(?s)<[^>]+>");
	}



	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		Matcher m = p.matcher(text);
		
		String result = null;
		while(m.find()) result = m.group();
		return result;
	}
}
