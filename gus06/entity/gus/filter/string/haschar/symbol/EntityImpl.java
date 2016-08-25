package gus06.entity.gus.filter.string.haschar.symbol;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160817";}


	private Service symbols;
	private String line;
	
	public EntityImpl() throws Exception
	{
		symbols = Outside.service(this,"gus.data.character.symbols1");
		line = (String) symbols.g();
	}

	

	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;

		String str = (String) obj;
		for(int i=0;i<str.length();i++)
			if(isSymbol(str.charAt(i))) return true;
		return false;
	}
	
	private boolean isSymbol(char c)
	{return line.indexOf(c)>=0;}
}
