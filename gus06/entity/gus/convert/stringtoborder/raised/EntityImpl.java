package gus06.entity.gus.convert.stringtoborder.raised;

import gus06.framework.*;
import javax.swing.BorderFactory;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140912";}

	public Object t(Object obj) throws Exception
	{
		if(obj!=null) throw new Exception("Invalid rule for raisedbevelborder: "+obj);
		return BorderFactory.createRaisedBevelBorder();
	}
}
