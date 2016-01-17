package gus06.entity.gus.feature.build.i.jlabel;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class EntityImpl implements Entity, G, I {

	public String creationDate() {return "20150711";}


	public Object g() throws Exception
	{return this;}
	
	public Object i() throws Exception
	{return new JLabel();}
}
