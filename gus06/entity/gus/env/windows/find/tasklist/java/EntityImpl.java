package gus06.entity.gus.env.windows.find.tasklist.java;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170410";}
	
	public static final String CMD = "tasklist";
		

	private Service execToString;


	public EntityImpl() throws Exception
	{
		execToString = Outside.service(this,"gus.data.perform.exec.tostring");
	}
	
	
	public Object g() throws Exception
	{
		String res = (String) execToString.t(CMD);
		
		String[] lines = res.trim().split("\n");
		int nb = lines.length;
		
		List list = new ArrayList();
		if(nb<2) return list;
		
		String[] delim = lines[1].split(" ");
		
		for(int i=2;i<nb;i++) if(isJavaLine(lines[i]))
		{
			String[] row = buildRow(lines[i],delim);
			
			Map map = new HashMap();
			map.put("image_name",		row[0].trim());
			map.put("pid",			extractInt(row[1]));
			map.put("session_name",		row[2].trim());
			map.put("session_number",	extractInt(row[3]));
			map.put("mem_usage",		extractInt(row[4]));
			
			list.add(map);
		}
		return list;
	}
	
	
	private String[] buildRow(String line, String[] delim)
	{
		String[] row = new String[delim.length];
		int offset = 0;
		for(int i=0;i<delim.length;i++)
		{
			int len = delim[i].length();
			row[i] = line.substring(offset,offset+len);
			offset += len+1;
		}
		return row;
	}
	
	
	
	private Integer extractInt(String s)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(isDigit(c)) b.append(c);
		}
		return new Integer(b.toString());
	}
	
	private boolean isDigit(char c)
	{
		int code = (int) c;
		return code>47 && code<58;
	}
	
	
	private boolean isJavaLine(String line)
	{
		String l = line.toLowerCase().trim();
		return l.startsWith("java.exe") || l.startsWith("javaw.exe");
	}
}
