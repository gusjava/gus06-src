package gus06.entity.gus.sys.quickreplace.buildexp;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160430";}


	private Service quote;
	
	public EntityImpl() throws Exception
	{
		quote = Outside.service(this,"gus.string.transform.regexp.quote");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		String center = o[0];
		int del_before = int_(o[1]);
		int del_after = int_(o[2]);
		
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<del_before;i++) b.append(".");
		b.append((String) quote.t(center));
		for(int i=0;i<del_after;i++) b.append(".");
		
		return b.toString();
	}
	
	
	private int int_(String s)
	{return Integer.parseInt(s);}
}