package gus06.entity.gus.beep.doublebeep;

import java.awt.Toolkit;

import gus06.framework.E;
import gus06.framework.Entity;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140808";}

	public void e() throws Exception
	{
		for(int i=0;i<2;i++)
		{
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(1000);
		}
	}
}
