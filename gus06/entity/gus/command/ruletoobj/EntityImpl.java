package gus06.entity.gus.command.ruletoobj;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140701";}

	
	private Service filterObject;
	
	public EntityImpl() throws Exception
	{
		filterObject = Outside.service(this,"gus.command.ruletoobj.filter");
	}
	
	

	public Object t(Object obj) throws Exception
	{
		String rule = (String) obj;
		String[] n = rule.split("'",2);
		Object result = Outside.resource(this,n[0]);
		
		if(n.length==1) return result;
		return filterObject.t(new Object[]{result,n[1]});
	}
}
