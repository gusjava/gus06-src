package gus06.entity.gus.math.matrix.build.identity;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150309";}
	
	
	public Object t(Object obj) throws Exception
	{
		int s = Integer.parseInt((String) obj);
		
		double[][] result = new double[s][s];
		
		for(int i=0;i<s;i++)
		for(int j=0;j<s;j++)
		result[i][j] = i==j?1:0;
		
		return result;
	}
}
