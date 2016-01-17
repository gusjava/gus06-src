package gus06.entity.gus.string.transform.regexp.extract.emailaddr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151014";}
	
	public static final String REGEX = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}";


	private Pattern p;

	public EntityImpl() throws Exception
	{
		p = Pattern.compile(REGEX,Pattern.DOTALL);
	}



	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		Matcher m = p.matcher(text.toLowerCase());
		
		StringBuffer b = new StringBuffer();
		while(m.find()) b.append(m.group()+"\n");
		return b.toString().trim();
	}
}
