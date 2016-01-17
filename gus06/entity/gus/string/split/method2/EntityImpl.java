package gus06.entity.gus.string.split.method2;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}
	
	/*
	 * \u0020 = hankaku supe-su (caract�re blanc normal)
	 * \u3000 = zenkaku supe-su (caract�re blanc japonais)
	 */
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.split("[\u0020\u3000]+");
	}
}
