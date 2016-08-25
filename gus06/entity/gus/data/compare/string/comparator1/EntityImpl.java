package gus06.entity.gus.data.compare.string.comparator1;

import gus06.framework.*;

public class EntityImpl implements Entity, T, F {

	public String creationDate() {return "20160805";}

	public static final double LIMIT = 0.75;
	
	
	private Service algo;
	
	
	public EntityImpl() throws Exception
	{
		algo = Outside.service(this,"gus.data.compare.string.algo.editdistance.wagnerfischer");
	}
	

	public Object t(Object obj) throws Exception
	{return new Double(compute(obj));}
	
	
	public boolean f(Object obj) throws Exception
	{return compute(obj)>=LIMIT;}

	
	
	private double compute(Object obj) throws Exception
	{
		String[] s = (String[]) obj;
		if(s.length!=2) throw new Exception("Wrong data number: "+s.length);
		
		if(s[0].equals(s[1])) return 1;
		if(s[0].equals("")) return 0;
		if(s[1].equals("")) return 0;
		
		boolean s1Long = isLong(s[0]);
		boolean s2Long = isLong(s[1]);
		
		if(s1Long && s2Long) return computeLongs(s[0],s[1]);
		if(!s1Long && !s2Long) return computeStrings(s[0],s[1]);
		return 0;
	}
	
	
	private double computeLongs(String s1, String s2)
	{
		return long_(s1)==long_(s2)?1:0;
	}
	
	
	private double computeStrings(String s1, String s2) throws Exception
	{
		Integer r = (Integer) algo.t(new String[]{s1,s2});
		
		int distance = r.intValue();
		int length1 = s1.length();
		int length2 = s2.length();
		
		if(distance>=length1) return 0;
		if(distance>=length2) return 0;
		
		int length = Math.min(length1,length2);
		return (length-distance)/(double)length;
	}
	
	
	private long long_(String s)
	{return Long.parseLong(s.replace(" ",""));}
	
	
	
	private boolean isLong(String s)
	{
		try{long_(s);return true;}
		catch(NumberFormatException e){return false;}
	}
}
