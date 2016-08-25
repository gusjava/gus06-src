package gus06.entity.gus.filter.string.build.mdots;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160406";}


	private Service prepare;

	public EntityImpl() throws Exception
	{prepare = Outside.service(this,"gus.filter.string.build.mdots.prepare");}

	
	
	public Object t(Object obj) throws Exception
	{return new Filter((String) obj);}
	
	
	private class Filter implements F
	{
		private String start;
		private String end;
		private boolean startInv;
		private boolean endInv;
		
		public Filter(String s) throws Exception
		{
			Object[] t = (Object[]) prepare.t(s);
			if(t.length!=4) throw new Exception("Wrong data number: "+t.length);
			
			start = (String) t[0];
			end = (String) t[1];
			startInv = ((Boolean) t[2]).booleanValue();
			endInv = ((Boolean) t[3]).booleanValue();
		}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String s0 = (String) obj;
			
			return s0.startsWith(start)^startInv && s0.endsWith(end)^endInv;
		}
	}
}
