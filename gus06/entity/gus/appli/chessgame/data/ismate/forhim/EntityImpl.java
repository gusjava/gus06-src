package gus06.entity.gus.appli.chessgame.data.ismate.forhim;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150412";}


	private Service myKingIsSafe;
	private Service checkMove;
	
	public EntityImpl() throws Exception
	{
		myKingIsSafe = Outside.service(this,"gus.appli.chessgame.data.issafe.forme.myking");
		checkMove = Outside.service(this,"gus.appli.chessgame.engine.checkmove");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		int[][] data = (int[][]) obj;
		int[][] data_ = inv(data);
		
		for(int i=0;i<8;i++)for(int j=0;j<8;j++)
		{
			int value0 = data_[i][j];
			if(value0>0)
			{
				for(int k=0;k<8;k++)for(int l=0;l<8;l++)
				{
					int value1 = data_[k][l];
					if(value1<=0)
					{
						int[] start = new int[]{i,j};
						int[] end = new int[]{k,l};
						if(checkMove.f(new Object[]{data_,start,end}))
						{
							int[][] data1 = clone(data_);
							int v = data1[i][j];
							data1[k][l] = v;
							data1[i][j] = 0;
							
							if(myKingIsSafe.f(data1)) return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	
	
	private int[][] inv(int[][] d)
	{
		int[][] d1 = new int[8][8];
		for(int i=0;i<8;i++) for(int j=0;j<8;j++)
		d1[7-i][j] = -1*d[i][j];
		return d1;
	}
	
	private int[][] clone(int[][] d)
	{
		int[][] d1 = new int[8][8];
		for(int i=0;i<8;i++) for(int j=0;j<8;j++)
		d1[i][j] = d[i][j];
		return d1;
	}
	
	
}
