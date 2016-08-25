package gus06.entity.gus.java.srccode.extract.classname;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160410";}

	private Pattern p = Pattern.compile("class +([A-Z][A-Za-z0-9_]*)",Pattern.DOTALL);
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		String src = (String) obj;
		
		Matcher m = p.matcher(src);
		if(!m.find()) throw new Exception("Class name extraction failed");
		return m.group(1);
	}
}
