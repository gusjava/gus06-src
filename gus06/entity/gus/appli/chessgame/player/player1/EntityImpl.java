package gus06.entity.gus.appli.chessgame.player.player1;

import gus06.framework.*;
import java.util.Set;

public class EntityImpl implements Entity, T, E {

	public String creationDate() {return "20150417";}


	private Service findMoves;
	private Service pickRandom;


	public EntityImpl() throws Exception
	{
		findMoves = Outside.service(this,"gus.appli.chessgame.player.player1.findmoves");
		pickRandom = Outside.service(this,"gus.data.collection.set.pick.random");
	}
	
	
	public void e() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		int[][] board = (int[][]) obj;
		Set moves = (Set) findMoves.t(board);
		return pickRandom.t(moves);
	}
}
