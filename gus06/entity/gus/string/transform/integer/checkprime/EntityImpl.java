package gus06.entity.gus.string.transform.integer.checkprime;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		try
		{
			int n = Integer.parseInt((String) obj);
			boolean check = isPrime(n);
			return ""+check;
		}
		catch(NumberFormatException e) {}
		return obj;
	}
	
	
	private boolean isPrime(int n)
	{
		for(int i=2;i<n;i++)
		{if(n%i==0)return false;}
		return true;
	}
}