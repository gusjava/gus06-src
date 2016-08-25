package gus06.entity.gus.appli.laboscript.gui.consolegui.format;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160624";}


	private Service format;


	public EntityImpl() throws Exception
	{
		format = Outside.service(this,"gus.string.transform.format.brackets.curly");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s.startsWith("{")) return s;
		return "{"+format(s)+"}";
	}
	
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
