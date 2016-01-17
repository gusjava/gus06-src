package gus06.entity.gus.appli.chessgame.data.issafe.forhim.hisking;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150412";}


	private Service isSafeCell;

	public EntityImpl() throws Exception
	{isSafeCell = Outside.service(this,"gus.appli.chessgame.data.issafe.forhim.cell");}
	
	
	public boolean f(Object obj) throws Exception
	{
		int[][] data = (int[][]) obj;
		
		int[] hisKing = findHisKing(data);
		if(hisKing==null) throw new Exception("King not found");
		
		return isSafeCell.f(new Object[]{data,hisKing});
	}
	
	
	private int[] findHisKing(int[][] data)
	{
		for(int i=0;i<8;i++)for(int j=0;j<8;j++)
		if(data[i][j]==-6) return new int[]{i,j};
		return null;
	}
}
