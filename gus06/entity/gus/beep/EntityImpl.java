package gus06.entity.gus.beep;

import java.awt.Toolkit;

import gus06.framework.E;
import gus06.framework.Entity;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140701";}

	public void e() throws Exception
	{Toolkit.getDefaultToolkit().beep();}
}
