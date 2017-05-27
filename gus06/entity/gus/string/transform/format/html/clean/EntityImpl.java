package gus06.entity.gus.string.transform.format.html.clean;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170112";}


	private Service decode;
	private Service rmScripts;


	public EntityImpl() throws Exception
	{
		decode = Outside.service(this,"gus.string.transform.format.html.decode");
		rmScripts = Outside.service(this,"gus.string.transform.format.html.rm.scripts");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		s = (String) rmScripts.t(s);
		
		String[] nn = s.split("<[^>]+>");
		
		StringBuffer b = new StringBuffer();
		
		for(String n:nn) 
		{
			String part = (String) decode.t(n);
			if(!part.equals("")) b.append(part+"\n");
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
