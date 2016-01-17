package gus06.entity.gus.app.entity.isvalid;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140902";}
	
	public static final String EXP = "([\\w]+\\.)*[\\w]+";


	private Service isKeyword;

	public EntityImpl() throws Exception
	{isKeyword = Outside.service(this,"gus.java.iskeyword");}
	
	
	
	public boolean f(Object obj) throws Exception
	{
		String name = (String) obj;

		if(name==null) return false;
		if(name.equals("")) return false;
		if(!name.matches(EXP)) return false;
    	
		String[] nn = name.split("\\.");
		for(String n:nn) if(isKeyword.f(n)) return false;
		return true;
	}
}
