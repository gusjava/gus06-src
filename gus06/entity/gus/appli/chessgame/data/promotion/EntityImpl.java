package gus06.entity.gus.appli.chessgame.data.promotion;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150410";}
	
	
	public void p(Object obj) throws Exception
	{
		int[][] data = (int[][]) obj;
		
		for(int i=0;i<8;i++)
		{
			if(data[7][i]==-1) data[7][i] = -5;
			if(data[0][i]==1) data[0][i] = 5;
		}
	}
}
