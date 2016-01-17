package gus06.entity.gus.java.srccode.toarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150527";}


	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String[]) return obj;
		if(obj instanceof String) return toArrray((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private String[] toArrray(String text)
	{
		String[] lines = text.split("\n");
		
		for(int i=0;i<lines.length;i++)
		lines[i] = format(lines[i]);
		
		return lines;
	}
	
	
	
	private String format(String line)
	{
		line = line.replace("\t","").trim();
		while(line.startsWith(" ")) line = line.substring(1);
		while(line.contains("  ")) line = line.replace("  "," ");
		return line;
	}
}
