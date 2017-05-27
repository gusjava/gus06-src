package gus06.entity.gus.convert.intarraytocolor;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160907";}


	
	public Object t(Object obj) throws Exception
	{
		int[] n = (int[]) obj;
		if(n.length!=3) throw new Exception("Wrong array length: "+n.length);
		
		return new Color(n[0],n[1],n[2]);
	}
}
