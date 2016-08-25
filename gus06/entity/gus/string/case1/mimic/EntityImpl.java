package gus06.entity.gus.string.case1.mimic;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160820";}
	
	
	
	private Service titled;
	private Service titledInv;
	private Service upper;
	private Service lower;

	public EntityImpl() throws Exception
	{
		titled = Outside.service(this,"gus.string.transform.str.titled");
		titledInv = Outside.service(this,"gus.string.transform.str.titled.inv");
		upper = Outside.service(this,"gus.string.transform.str.upper");
		lower = Outside.service(this,"gus.string.transform.str.lower");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String s1 = o[0];
		String s2 = o[1];
		
		String s1_AAA = (String) upper.t(s1);
		if(s1.equals(s1_AAA)) return upper.t(s2);
		
		String s1_aaa = (String) lower.t(s1);
		if(s1.equals(s1_aaa)) return lower.t(s2);
		
		String s1_Aaa = (String) titled.t(s1);
		if(s1.equals(s1_Aaa)) return titled.t(s2);
		
		String s1_aAa = (String) titledInv.t(s1);
		if(s1.equals(s1_aAa)) return titledInv.t(s2);
		
		return s2;
	}
}
