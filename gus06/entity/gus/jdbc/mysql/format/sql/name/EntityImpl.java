package gus06.entity.gus.jdbc.mysql.format.sql.name;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}

	
	private Service isKeyword;
	
	public EntityImpl() throws Exception
	{isKeyword = Outside.service(this,"gus.jdbc.mysql.format.iskeyword");}

	

	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		if(name.contains("."))
			return format(name.split("\\."));
		return format(name);
	}
	
	
	
	private String format(String[] n) throws Exception
	{
		if(n.length==0) return "";
		StringBuffer b = new StringBuffer();
		for(int i=0;i<n.length;i++) b.append(format(n[i])+".");
		b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	private String format(String value) throws Exception
	{
		if(isKeyword.f(value)) return "`"+value+"`";
		return value;
	}
}
