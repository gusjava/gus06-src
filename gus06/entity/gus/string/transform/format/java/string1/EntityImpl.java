package gus06.entity.gus.string.transform.format.java.string1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160811";}


	private Service uuEncode;


	public EntityImpl() throws Exception
	{
		uuEncode = Outside.service(this,"gus.string.transform.encoding.uu.encode.a1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		s = s.replace("\\","\\\\")
			.replace("\"","\\\"")
			.replace("\n","\\n")
			.replace("\t","\\t")
		;
		
		return uuEncode.t(s);
	}
}
