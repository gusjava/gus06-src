package gus06.entity.gus.string.extract.extract1.pattern.greedy;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160823";}


	private Service quote;

	public EntityImpl() throws Exception
	{
		quote = Outside.service(this,"gus.string.transform.regexp.quote");
	}



	
	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		String[] n = rule.split("\\*");
		
		if(n.length!=2) throw new Exception("Invalid rule: "+rule);
		if(n[1].length()==0) throw new Exception("Invalid rule: "+rule);
		
		String s1 = ""+n[1].charAt(0);
		return quote.t(n[0])+"([^"+quote.t(s1)+"]+)"+quote.t(n[1]);
	}
}
