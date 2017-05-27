package gus06.entity.gus.convert.stringtoinputstream;

import gus06.framework.*;
import java.io.ByteArrayInputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161015";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		String s = (String) obj;
		byte[] b = s.getBytes("UTF-8");
		return new ByteArrayInputStream(b);
	}
}
