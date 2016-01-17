package gus06.entity.gus.convert.stringtoborder.titled;

import gus06.framework.*;
import javax.swing.BorderFactory;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140912";}

	public Object t(Object obj) throws Exception
	{
		String title = (String) obj;
		return BorderFactory.createTitledBorder(title);
	}
}
