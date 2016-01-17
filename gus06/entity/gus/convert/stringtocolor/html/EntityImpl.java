package gus06.entity.gus.convert.stringtocolor.html;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{return htmlToColor((String) obj);}

    
    
	private Color htmlToColor(String code) throws Exception
	{
		if(code.startsWith("#"))
		code = code.substring(1);
    	
		if(code.length()==3) return buildColor3(code);
		if(code.length()==6) return buildColor6(code);
		throw new Exception("Invalid html color code: "+code);
	}

    
    
    private Color buildColor3(String code)
    {
    	String r_ = code.substring(0,1);
    	String g_ = code.substring(1,2);
    	String b_ = code.substring(2,3);
    	
    	int r = Integer.parseInt(r_+r_,16);
    	int g = Integer.parseInt(g_+g_,16);
    	int b = Integer.parseInt(b_+b_,16);
    	return new Color(r,g,b);
    }
    
    
    private Color buildColor6(String code)
    {
    	String r_ = code.substring(0,2);
    	String g_ = code.substring(2,4);
    	String b_ = code.substring(4,6);
    	
    	int r = Integer.parseInt(r_,16);
    	int g = Integer.parseInt(g_,16);
    	int b = Integer.parseInt(b_,16);
    	return new Color(r,g,b);
    }
}

