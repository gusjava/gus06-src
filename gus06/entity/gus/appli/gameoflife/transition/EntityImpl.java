package gus06.entity.gus.appli.gameoflife.transition;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150323";}


	public Object t(Object obj) throws Exception
	{
		boolean[][] b = (boolean[][]) obj;
		
		int x = b.length;
		if(x==0) throw new Exception("Empty size for data");
		
		int y = b[0].length;
		if(y==0) throw new Exception("Empty size for data");
		
		boolean[][] b1 = new boolean[x][y];
		for(int i=0;i<x;i++)
		for(int j=0;j<y;j++)
		b1[i][j] = findNextValue(b,i,j);
		
		return b1;
	}

	private boolean findNextValue(boolean[][] b, int i, int j)
	{
		int n = aliveNeighbours(b,i,j);
		if(b[i][j]) return n==2 || n==3;
		return n==3;
	}
	
	private int aliveNeighbours(boolean[][] b, int i, int j)
	{
		int x = b.length;
		int y = b[0].length;
		
		int i1 = i>0?i-1:x-1;
		int i2 = i<x-1?i+1:0;
		
		int j1 = j>0?j-1:y-1;
		int j2 = j<y-1?j+1:0;
		
		int n = 0;
		
		if(b[i1][j1]) n++;
		if(b[i1][j]) n++;
		if(b[i1][j2]) n++;
		
		if(b[i][j1]) n++;
		if(b[i][j2]) n++;
		
		if(b[i2][j1]) n++;
		if(b[i2][j]) n++;
		if(b[i2][j2]) n++;
		
		return n;
	}
}