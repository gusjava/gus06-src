package gus06.entity.gus.appli.chessgame.data.newboard;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150409";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object g() throws Exception
	{
		return new int[][]{
			{-2,-3,-4,-5,-6,-4,-3,-2},
			{-1,-1,-1,-1,-1,-1,-1,-1},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1},
			{2,3,4,5,6,4,3,2}
		};
	}
}
