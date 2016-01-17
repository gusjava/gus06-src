package gus06.entity.gus.sys.expression1.external;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}

	private Service findValue;
	private Service apply;

	public EntityImpl() throws Exception
	{
		findValue = Outside.service(this,"gus.sys.expression1.findvalue");
		apply = Outside.service(this,"gus.sys.expression1.apply");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List pools = (List) o[0];
		Map opMap = (Map) o[1];
			
		return new External(pools,opMap);
	}
	
	
	
	
	private class External implements T
	{
		private List pools;
		private Map opMap;
		
		public External(List pools, Map opMap)
		{
			this.pools = pools;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			if(obj instanceof String)
			{
				String key = (String) obj;
				return findValue.t(new Object[]{pools,key});
			}
			else if(obj instanceof Object[])
			{
				Object[] o = (Object[]) obj;
				if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
				
				Object value = o[0];
				Object op = o[1];
		
				return apply.t(new Object[]{opMap,value,op});
			}
			else throw new Exception("Invalid data type: "+obj.getClass().getName());
		}
	}
}