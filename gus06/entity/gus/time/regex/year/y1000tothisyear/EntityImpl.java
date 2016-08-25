package gus06.entity.gus.time.regex.year.y1000tothisyear;

import gus06.framework.*;
import java.util.Calendar;
import java.util.Date;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160612";}

	private String regex;

	public EntityImpl() throws Exception
	{
		Calendar now = Calendar.getInstance(); 
		int thisYear = now.get(Calendar.YEAR);
		
		StringBuffer b = new StringBuffer();
		b.append("((1[0-9]{3})");
		
		for(int i=2000;i<=thisYear;i++) b.append("|"+i);
		b.append(")");
		
		regex = b.toString();
	}
	
	
	public Object g() throws Exception
	{return regex;}
}
