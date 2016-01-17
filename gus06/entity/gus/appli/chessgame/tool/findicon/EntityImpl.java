package gus06.entity.gus.appli.chessgame.tool.findicon;

import gus06.framework.*;
import javax.swing.Icon;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150409";}
	
	public static final String GAME = "CHESS1";
	
	
	private Service iconProvider;

	public EntityImpl() throws Exception
	{iconProvider = Outside.service(this,"gus.icon.provider");}
	
	
	public Object t(Object obj) throws Exception
	{return icon((Integer) obj);}
	
	
	private Icon icon(String key) throws Exception
	{return (Icon) iconProvider.t(GAME+"_"+key);}
	
	
	private Icon icon(Integer value) throws Exception
	{
		if(value==null) return null;
		int v = value.intValue();
		
		switch(v)
		{
			case 1:return icon("pone1");
			case 2:return icon("rook1");
			case 3:return icon("knight1");
			case 4:return icon("bishop1");
			case 5:return icon("queen1");
			case 6:return icon("king1");
		
			case -1:return icon("pone2");
			case -2:return icon("rook2");
			case -3:return icon("knight2");
			case -4:return icon("bishop2");
			case -5:return icon("queen2");
			case -6:return icon("king2");
		}
		return null;
	}
}
