package gus06.entity.gus.string.transform.line.length.avg;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150929";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		int sum = 0;
		for(String n:nn) sum += n.trim().length();
		int count = nn.length;
		
		double avg = (double)sum/(double)count;
		return ""+avg;
	}
}
