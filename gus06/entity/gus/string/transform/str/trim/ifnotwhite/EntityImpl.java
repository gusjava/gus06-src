package gus06.entity.gus.string.transform.str.trim.ifnotwhite;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String s_ = s.trim();
		return s_.equals("")?s:s_;
	}
}
