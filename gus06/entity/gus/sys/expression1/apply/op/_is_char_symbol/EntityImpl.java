package gus06.entity.gus.sys.expression1.apply.op._is_char_symbol;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160816";}


	private Service symbols;
	private String line;
	
	public EntityImpl() throws Exception
	{
		symbols = Outside.service(this,"gus.data.character.symbols1");
		line = (String) symbols.g();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		if(!(obj instanceof String)) return Boolean.FALSE;
		
		String s = (String) obj;
		return new Boolean(isSymbol(s.charAt(0)));
	}
	
	private boolean isSymbol(char c)
	{return line.indexOf(c)>=0;}
}