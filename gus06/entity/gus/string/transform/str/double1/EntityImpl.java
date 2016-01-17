package gus06.entity.gus.string.transform.str.double1;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return s+s;
	}
}
