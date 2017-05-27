package gus06.entity.gus.string.transform.xhtml.indent;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170218";}


	private Service evaluate;
	private Service display;


	public EntityImpl() throws Exception
	{
		evaluate = Outside.service(this,"gus.sys.xhtmlparser1.engine");
		display = Outside.service(this,"gus.sys.xhtmlparser1.indentation");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String offset = getOffset(s);
		
		Object data = evaluate.t(s);
		String r = (String) display.t(data);
		
		return addOffset(r,offset);
	}
	
	
	
	private String getOffset(String s)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c=='\t') b.append(c);
			else break;
		}
		return b.toString();
	}
	
	
	private String addOffset(String s, String offset)
	{
		StringBuffer b = new StringBuffer();
		String[] nn = s.split("\n");
		for(String n:nn) b.append(offset+n+"\n");
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
