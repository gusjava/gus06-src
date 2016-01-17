package gus06.entity.gus.filter.string.build.oneofthem.lines1;


import gus06.framework.*;



public class EntityImpl implements Entity, T {



	public String creationDate() {return "20150529";}


	private Service cuttingMethod;
	
	public EntityImpl() throws Exception
	{
		cuttingMethod = Outside.service(this,"gus.string.split.method1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		String[] lines = text.toLowerCase().split("\n");
		return new F_oneOfThem(lines);
	}
	
	
	private class F_oneOfThem implements F
	{
		private String[] lines;
		public F_oneOfThem(String[] lines)
		{this.lines = lines;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (obj.toString()).toLowerCase();
			for(int i=0;i<lines.length;i++)
			if(match(lines[i],str)) return true;
			return false;
		}
	}
	
	
	
	
	private boolean match(String line, String s)
	{
		if(line.startsWith("*") && line.endsWith("*"))
			return s.contains(line.replace("*",""));
		
		if(line.endsWith("*"))
			return s.startsWith(line.replace("*",""));
		
		if(line.startsWith("*"))
			return s.endsWith(line.replace("*",""));
		
		return s.equals(line);
	}
}
