package gus06.entity.gus.string.split.words1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141105";}

	public static String wordDelimRegexp = "[\n\r\t\\\\/\\[\\]<># ,;(){}!:=\\-\"'”\\*\\.\\?\\+@_]+";
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.split(wordDelimRegexp);
	}
}
