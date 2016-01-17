package gus06.entity.gus.java.srccode.extract.imports1;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140915";}

	private Pattern p = Pattern.compile("import +([^;]+);");
	
	
	private Service toArray;

	public EntityImpl() throws Exception
	{toArray = Outside.service(this,"gus.java.srccode.toarray");}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		String[] lines = (String[]) toArray.t(obj);
		
		HashSet set = new HashSet();
		for(String line:lines)
		{
			if(line.startsWith("import "))
			set.add(extract(line));
		}
		return set;
	}
	
	
	
	private String extract(String line) throws Exception
	{
		Matcher m = p.matcher(line);
		if(!m.find()) throw new Exception("Import extraction failed for line: "+line);
		return m.group(1);
	}
}
