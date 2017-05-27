package gus06.entity.gus.find.color;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service stringToColor;
	private Service intArrayToColor;

	public EntityImpl() throws Exception
	{
		stringToColor = Outside.service(this,"gus.convert.stringtocolor");
		intArrayToColor = Outside.service(this,"gus.convert.intarraytocolor");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Color) return obj;
		if(obj instanceof Integer) return integerToColor((Integer) obj);
		if(obj instanceof String) return stringToColor.t(obj);
		if(obj instanceof int[]) return intArrayToColor.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
		
	private Color integerToColor(Integer n)
	{return new Color(n.intValue());}
}
