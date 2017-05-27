package gus06.entity.gus.string.extract.html.tag.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

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
		
		List list = new ArrayList();
		while(m.find()) list.add(m.group());
		return list;
	}
}
