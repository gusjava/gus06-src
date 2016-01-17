package gus06.manager.gus.gyem.m063.t.resource.provider;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String rule = (String) o[0];
		Object src = o[1];
		
		try
		{
			rule = formatRule(rule);
			
			if(rule.equals("null")) return null;
			if(rule.equals("main")) return m;
			if(has(rule)) return get(rule);
			
			return ((T) module(M064_T_RESOURCE_BUILDER)).t(new Object[]{rule,src});
		}
		catch(Exception e)
		{
			String message = "Resource building failed with rule: "+rule;
			throw new Exception(message,e);
		}
	}
	
	
	
	
	
	
	
	private String formatRule(String s)
    {
    	if(!s.contains("-")) return s;
    	String[] n = s.split("-",2);
    	if(!isInteger(n[1])) return s;
    	return n[0];	
    }
    
    private boolean isInteger(String s)
    {
    	try{Integer.parseInt(s);return true;}
    	catch(Exception e){return false;}
    }
}