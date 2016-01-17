package gus06.entity.gus.convert.stringtoborder.empty;

import gus06.framework.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140912";}


	public Object t(Object obj) throws Exception
	{return build((String) obj);}
	
	
	
	private Border build(String rule) throws Exception
	{
		if(rule==null) return BorderFactory.createEmptyBorder();
		String[] n = rule.split(" ");
		
		if(n.length==1) return BorderFactory.createEmptyBorder(int_(n[0]),int_(n[0]),int_(n[0]),int_(n[0]));
		if(n.length==2) return BorderFactory.createEmptyBorder(int_(n[0]),int_(n[1]),int_(n[0]),int_(n[1]));
		if(n.length==4) return BorderFactory.createEmptyBorder(int_(n[0]),int_(n[1]),int_(n[2]),int_(n[3]));
		
		throw new Exception("Invalid empty border rule: "+rule);
	}
	
	private int int_(String s)
	{return Integer.parseInt(s);}
}
