package gus06.entity.gus.convert.stringtodate;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141106";}

	//15
	private SimpleDateFormat sdf15 = new SimpleDateFormat("yyyyMMdd_HHmmss");
	//10
	private SimpleDateFormat sdf10a = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf10b = new SimpleDateFormat("yyyy.MM.dd");
	private SimpleDateFormat sdf10c = new SimpleDateFormat("yyyy MM dd");
	private SimpleDateFormat sdf10d = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf10e = new SimpleDateFormat("dd MM yyyy");
	//8
	private SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
	//7
	private SimpleDateFormat sdf7 = new SimpleDateFormat("MM/yyyy");
	//4
	private SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy");

	
	
	public Object t(Object obj) throws Exception
	{return stringToDate((String) obj);}
		
		
		
		
	private Date stringToDate(String s) throws Exception
	{
		Date d = null;
		
		int l = s.length();
		
		if(l==15)
		{
			d = parse(sdf15,s);
			if(d!=null) return d;
		}
		if(l==10)
		{
			d = parse(sdf10a,s);
			if(d!=null) return d;
			
			d = parse(sdf10b,s);
			if(d!=null) return d;
			
			d = parse(sdf10c,s);
			if(d!=null) return d;
			
			d = parse(sdf10d,s);
			if(d!=null) return d;
			
			d = parse(sdf10e,s);
			if(d!=null) return d;
		}
		if(l==8)
		{
			d = parse(sdf8,s);
			if(d!=null) return d;
		}
		if(l==7)
		{
			d = parse(sdf7,s);
			if(d!=null) return d;
		}
		if(l==4)
		{
			d = parse(sdf4,s);
			if(d!=null) return d;
		}
		
		try{return new Date(Long.parseLong(s));}
		catch(NumberFormatException e){}
		
		throw new Exception("Unknown date syntax: "+s);
	}
	
	
	
	
	private Date parse(SimpleDateFormat sdf, String s)
	{
		try{return sdf.parse(s);}
		catch(Exception e) {return null;}
	}
}
