package gus06.entity.gus.sys.parser3.resolver1.op.seq.sum.motley.doublematrix;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170121";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		double[][] matrix = (double[][]) oo[0];
		int x1 = matrix.length;
		int y1 = x1>0?matrix[0].length:0;
		
		double[][] output = new double[x1][y1];
		for(int i=0;i<x1;i++) 
		for(int j=0;j<y1;j++) 
		output[i][j] = matrix[i][j];
			
		for(int i=1;i<oo.length;i++) add(x1,y1,output,oo[i]);
		return output;
	}
	
	
	private void add(int x1, int y1, double[][] matrix, Object o) throws Exception
	{
		if(o==null) throw new Exception("Invalid null value");
		
		if(o instanceof Number)
		{
			double n = ((Number) o).doubleValue();
			
			for(int i=0;i<x1;i++) 
			for(int j=0;j<y1;j++) 
			matrix[i][j] += n;
			
			return;
		}
		
		if(o instanceof double[])
		{
			double[] nn = (double[]) o;
			
			if(nn.length!=y1) throw new Exception("Invalid array length for sum: "+nn.length);
			for(int i=0;i<x1;i++) 
			for(int j=0;j<y1;j++) 
			matrix[i][j] += nn[j];
			
			return;
		}
		
		if(o instanceof int[])
		{
			int[] nn = (int[]) o;
			
			if(nn.length!=y1) throw new Exception("Invalid array length for sum: "+nn.length);
			for(int i=0;i<x1;i++) 
			for(int j=0;j<y1;j++) 
			matrix[i][j] += nn[j];
			
			return;
		}
		
		if(o instanceof double[][])
		{
			double[][] nn = (double[][]) o;
		
			if(nn.length!=x1) throw new Exception("Invalid matrix length for sum");
			if(x1>0 && nn[0].length!=y1) throw new Exception("Invalid matrix length for sum");
			
			for(int i=0;i<x1;i++) 
			for(int j=0;j<y1;j++) 
			matrix[i][j] += nn[i][j];
			
			return;
		}
		
		if(o instanceof int[][])
		{
			int[][] nn = (int[][]) o;
		
			if(nn.length!=x1) throw new Exception("Invalid matrix length for sum");
			if(x1>0 && nn[0].length!=y1) throw new Exception("Invalid matrix length for sum");
			
			for(int i=0;i<x1;i++) 
			for(int j=0;j<y1;j++) 
			matrix[i][j] += nn[i][j];
			
			return;
		}
		
		throw new Exception("Invalid data type: "+o.getClass().getName());
	}
}
