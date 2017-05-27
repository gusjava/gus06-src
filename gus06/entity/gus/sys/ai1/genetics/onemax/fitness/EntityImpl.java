package gus06.entity.gus.sys.ai1.genetics.onemax.fitness;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170423";}

	
	
	public Object t(Object obj) throws Exception
	{
		String data = (String) obj;
		int sum = 0;
		
		int len = data.length();
		for(int i=0;i<len;i++)
		if(data.charAt(i)=='1') sum++;
		
		return new Integer(sum);
	}
}