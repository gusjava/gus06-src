package gus06.entity.gus.math.matrix.op.clone;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150309";}
	
	
	public Object t(Object obj) throws Exception
	{
		double[][] d = (double[][]) obj;
		
		int x = d.length;
		int y = d[0].length;
		
		double[][] result = new double[x][y];
		
		for(int i=0;i<x;i++)
		for(int j=0;j<y;j++)
		result[i][j] = d[i][j];
		
		return result;
	}
}
