package gus06.entity.gus.math.matrix.build.empty;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150309";}
	
	
	public Object t(Object obj) throws Exception
	{
		int[] s = ((int[]) obj);
		if(s.length!=2) throw new Exception("Wrong data number: "+s.length);
		
		int x = s[0];
		int y = s[1];
		
		double[][] result = new double[x][y];
		
		for(int i=0;i<x;i++)
		for(int j=0;j<y;j++)
		result[i][j] = 0;
		
		return result;
	}
}
