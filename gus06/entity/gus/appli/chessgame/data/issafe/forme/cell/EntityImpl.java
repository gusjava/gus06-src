package gus06.entity.gus.appli.chessgame.data.issafe.forme.cell;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150411";}


	private Service isCellSafe;
	
	public EntityImpl() throws Exception
	{isCellSafe = Outside.service(this,"gus.appli.chessgame.data.issafe.forhim.cell");}
	
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		int[][] data = (int[][]) o[0];
		int[] cell = (int[]) o[1];
		
		return isCellSafe.f(new Object[]{inv(data),inv(cell)});
	}
	
	private int[][] inv(int[][] d)
	{
		int[][] d1 = new int[8][8];
		for(int i=0;i<8;i++) for(int j=0;j<8;j++)
		d1[7-i][j] = -1*d[i][j];
		return d1;
	}
	
	private int[] inv(int[] p)
	{
		return new int[]{7-p[0],p[1]};
	}
}
