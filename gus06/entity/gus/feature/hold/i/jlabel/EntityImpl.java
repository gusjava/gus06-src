package gus06.entity.gus.feature.hold.i.jlabel;

import gus06.framework.*;
import javax.swing.JLabel;

public class EntityImpl implements Entity, G, I {

	public String creationDate() {return "20150711";}

	private JLabel label;
	
	public EntityImpl() throws Exception
	{label = new JLabel();}


	public Object g() throws Exception
	{return label;}
	
	public Object i() throws Exception
	{return label;}
}
