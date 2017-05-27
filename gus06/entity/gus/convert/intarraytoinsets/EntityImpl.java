package gus06.entity.gus.convert.intarraytoinsets;

import gus06.framework.*;
import java.awt.Insets;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160907";}


	
	public Object t(Object obj) throws Exception
	{
		int[] n = (int[]) obj;
		
		if(n.length==1) return new Insets(n[0],n[0],n[0],n[0]);
		if(n.length==2) return new Insets(n[0],n[1],n[0],n[1]);
		if(n.length==4) return new Insets(n[0],n[1],n[2],n[3]);
		
		throw new Exception("Wrong array length: "+n.length);
	}
}
