package gus06.entity.gus.appli.chessgame.engine;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, E, R, G, F {

	public String creationDate() {return "20150410";}


	private Service newBoard;
	private Service performMove;
	private Service checkMove;
	private Service promotion;
	private Service myKingIsSafe;
	private Service hisKingIsSafe;
	private Service isMate;
	
	private int[][] board;
	private int[][] board0;
	
	private boolean isWhite;
	private String state;
	private Object move;
	
	private boolean[] blackMoved;
	private boolean[] whiteMoved;
	
	
	
	
	public EntityImpl() throws Exception
	{
		newBoard = Outside.service(this,"gus.appli.chessgame.data.newboard");
		performMove = Outside.service(this,"gus.appli.chessgame.data.move");
		checkMove = Outside.service(this,"gus.appli.chessgame.engine.checkmove");
		promotion = Outside.service(this,"gus.appli.chessgame.data.promotion");
		myKingIsSafe = Outside.service(this,"gus.appli.chessgame.data.issafe.forme.myking");
		hisKingIsSafe = Outside.service(this,"gus.appli.chessgame.data.issafe.forhim.hisking");
		isMate = Outside.service(this,"gus.appli.chessgame.data.ismate.forhim");
		
		board0 = new int[8][8];
	}
	
	
	
	
	public void e() throws Exception
	{
		board = (int[][]) newBoard.g();
		backup();
		
		blackMoved = new boolean[]{false,false,false,false,false,false,false,false};
		whiteMoved = new boolean[]{false,false,false,false,false,false,false,false};
		
		isWhite =  true;
		state = "";
	}
	
	
	
	
	public Object g() throws Exception
	{
		Map map = new HashMap();
		map.put("board",board);
		map.put("move",move);
		map.put("player",player());
		map.put("state",state);
		
		return map;
	}
	
	
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		int[] start = (int[]) o[0];
		int[] end = (int[]) o[1];
		
		move = null;
		
		if(!checkMove.f(new Object[]{inv_(board),inv_(start),inv_(end)}))
			return false;
		
		
		int x0 = start[0];
		int y0 = start[1];
		
		int x1 = end[0];
		int y1 = end[1];
		
		if(x0==0 && y0==4 && x1==0 && y1==6 && (blackMoved[4] || blackMoved[7]))
			return false;
		
		if(x0==0 && y0==4 && x1==0 && y1==2 && (blackMoved[4] || blackMoved[0]))
			return false;
		
		if(x0==3 && x1==2 && y0!=y1 && board[3][y0]==1 && board[3][y1]==-1 && board[2][y1]==0 && board[1][y1]==0 && 
		(board0[3][y1]!=0 || board0[2][y1]!=0 || board0[1][y1]!=-1))
			return false;
		
		
		
		if(x0==7 && y0==4 && x1==7 && y1==6 && (whiteMoved[4] || whiteMoved[7]))
			return false;
		
		if(x0==7 && y0==4 && x1==7 && y1==2 && (whiteMoved[4] || whiteMoved[0]))
			return false;
		
		if(x0==4 && x1==5 && y0!=y1 && board[4][y0]==-1 && board[4][y1]==1 && board[5][y1]==0 && board[6][y1]==0 && 
		(board0[4][y1]!=0 || board0[5][y1]!=0 || board0[6][y1]!=1))
			return false;
		
		
		
		backup();
		
		performMove.p(new Object[]{board,start,end});
		promotion.p(board);
		
		int[][] board_ = inv_(board);
		
		if(!myKingIsSafe.f(board_))
		{rollBack();return false;}
		
		state = "";
		if(!hisKingIsSafe.f(board_)) state = "check";
		if(state.equals("check")) if(isMate.f(board_)) state = "mate";
		
		if(x0==0) blackMoved[y0] = true;
		else if(x0==7) whiteMoved[y0] = true;
		
		move = new Object[]{start,end};
		isWhite = !isWhite;
		return true;
	}
	
	
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("board")) return board;
		if(key.equals("board_")) return inv_(board);
		if(key.equals("board0")) return board0;
		if(key.equals("move")) return move;
		if(key.equals("player")) return player();
		if(key.equals("state")) return state;
		
		if(key.equals("keys")) return new String[]{"board","board_","board0","move","player","state"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	private String player()
	{return isWhite?"white":"black";}
	
	
	
	private int[][] inv_(int[][] d)	{return isWhite?d:inv(d);}
	private int[] inv_(int[] p)	{return isWhite?p:inv(p);}
	
	
	
	
	private int[][] inv(int[][] d)
	{
		if(d==null) return null;
		int[][] d1 = new int[8][8];
		for(int i=0;i<8;i++) for(int j=0;j<8;j++)
		d1[7-i][j] = -1*d[i][j];
		return d1;
	}
	
	private int[] inv(int[] p)
	{
		if(p==null) return null;
		return new int[]{7-p[0],p[1]};
	}
	
	
	
	private void backup()
	{
		for(int i=0;i<8;i++) for(int j=0;j<8;j++)
		board0[i][j] = board[i][j];
	}
	
	private void rollBack()
	{
		for(int i=0;i<8;i++) for(int j=0;j<8;j++)
		board[i][j] = board0[i][j];
	}
}
