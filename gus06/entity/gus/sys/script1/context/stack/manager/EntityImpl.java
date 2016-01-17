package gus06.entity.gus.sys.script1.context.stack.manager;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}
	
	public static final String S_OWNER = "owner";
	public static final String S_POOL = "pool";
	public static final String S_LEVEL = "level";
	public static final String S_CLOSED = "closed";
	
	public static final String K_STACK = "stack";
	
	public static final String C_LEVEL = "level";
	public static final String C_POOL = "pool";
	
	public static final String P_PARENT = "parent";


	private Service buildMap;
	
	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.map.map1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Map[] o = (Map[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = o[0];
		Map owner = o[1];
		
		return new Holder(context,owner);
	}
	
	
	
	private class Holder implements E, G, R, F
	{
		private Map context;
		private Map owner;
		
		private Map stack;
		private Map pool;
		
		private int level;
		private String stackName;
		private boolean closed;
		
		public Holder(Map context, Map owner) throws Exception
		{
			this.context = context;
			this.owner = owner;
			
			level = stackLevel();
			stackName = "stack_"+level;
			closed = false;
			
			stack = (Map) buildMap.t(stackName);
			pool = (Map) buildMap.t("pool["+stackName+"]");
			
			context.put(stackName,stack);
			context.put(C_LEVEL,new Integer(level));
			
			stack.put(S_OWNER,owner);
			stack.put(S_POOL,pool);
			stack.put(S_LEVEL,new Integer(level));
			stack.put(S_CLOSED,""+closed);
			
			owner.put(K_STACK,stack);
			pool.put(P_PARENT,parentPool());
		}
		
		
		public Object g() throws Exception
		{return pool;}
		
		
		public boolean f(Object obj) throws Exception
		{return closed;}
		
		
		public Object r(String key) throws Exception
		{
			if(key.equals("stack")) return stack;
			if(key.equals("owner")) return owner;
			if(key.equals("pool")) return pool;
			if(key.equals("level")) return ""+level;
			if(key.equals("closed")) return ""+closed;
			
			if(key.equals("keys")) return new String[]{"stack","owner","pool","level","closed"};
			
			throw new Exception("Unknown key: "+key);
		}
		
		
		public void e()  throws Exception
		{
			int n = level;
			while(context.containsKey("stack_"+n))
			{context.remove("stack_"+n);n++;}
			
			closed = true;
			stack.put(S_CLOSED,""+closed);
			context.put(C_LEVEL,new Integer(level-1));
		}
		
		
		private int stackLevel()
		{
			int n = 1;
			while(context.containsKey("stack_"+n)) n++;
			return n;
		}
		
		private Map parentPool()
		{
			if(level==1) return (Map) context.get(C_POOL);
			Map parentStack = (Map) context.get("stack_"+(level-1));
			return (Map) parentStack.get(S_POOL);
		}
	}
}
