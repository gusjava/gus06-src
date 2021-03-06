package gus06.entity.gus.java.srccode.extract.entity.creationdate;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140827";}

	private Pattern p = Pattern.compile("\"([^\"]+)\"");
	
	
	private Service toArray;

	public EntityImpl() throws Exception
	{toArray = Outside.service(this,"gus.java.srccode.toarray");}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		String[] lines = (String[]) toArray.t(obj);
		for(String line:lines)
		{
			if(line.startsWith("public String creationDate()"))
			return extract(line);
		}
		return null;
	}
	
	
	
	private String extract(String line) throws Exception
	{
		Matcher m = p.matcher(line);
		if(!m.find()) throw new Exception("Creation date extraction failed for line: "+line);
		return m.group(1);
	}
}
