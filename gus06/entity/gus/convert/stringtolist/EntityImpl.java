package gus06.entity.gus.convert.stringtolist;

import gus06.framework.*;
import java.util.Arrays;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160518";}

	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split("\n");
		return new ArrayList(Arrays.asList(n));
	}
}
