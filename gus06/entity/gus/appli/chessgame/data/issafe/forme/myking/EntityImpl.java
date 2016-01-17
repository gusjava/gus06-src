package gus06.entity.gus.appli.chessgame.data.issafe.forme.myking;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150411";}


	private Service isSafeCell;

	public EntityImpl() throws Exception
	{isSafeCell = Outside.service(this,"gus.appli.chessgame.data.issafe.forme.cell");}
	
	
	public boolean f(Object obj) throws Exception
	{
		int[][] data = (int[][]) obj;
		
		int[] myKing = findMyKing(data);
		if(myKing==null) throw new Exception("King not found");
		
		return isSafeCell.f(new Object[]{data,myKing});
	}
	
	
	private int[] findMyKing(int[][] data)
	{
		for(int i=0;i<8;i++)for(int j=0;j<8;j++)
		if(data[i][j]==6) return new int[]{i,j};
		return null;
	}
}
