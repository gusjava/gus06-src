package gus06.entity.gus.convert.stringtofont;

import gus06.framework.*;
import java.awt.Font;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	public EntityImpl() throws Exception
	{
	}


	public Object t(Object obj) throws Exception
	{return stringToFont((String) obj);}
	
	
	private Font stringToFont(String s) throws Exception
 	{
		s = s.toUpperCase();
		String[] n = s.split(" ");
        
		if(n.length!=3)
		throw new Exception("Invalid syntax: "+s);
        
		String name = n[0];
		int style = findStyle(n[1]);
		int size = Integer.parseInt(n[2]);
        
		return new Font(name,style,size);
	}
    
    
	private int findStyle(String info)
	{
		if(info.toLowerCase().equals("plain")) return 0;
		if(info.toLowerCase().equals("bold")) return 1;
		if(info.toLowerCase().equals("italic")) return 2;
		if(info.toLowerCase().equals("bold|italic")) return 3;
		if(info.toLowerCase().equals("italic|bold")) return 3;
		return Integer.parseInt(info);
	}
}
