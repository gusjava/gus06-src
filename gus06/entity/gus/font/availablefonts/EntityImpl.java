package gus06.entity.gus.font.availablefonts;

import gus06.framework.*;
import java.awt.GraphicsEnvironment;
import java.util.List;
import java.util.ArrayList;
import java.awt.Font;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160501";}
	
	
	private List list;


	public EntityImpl() throws Exception
	{
		String[] names = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		list = new ArrayList();
		for(String name:names)
		list.add(new Font(name,Font.PLAIN,12));
	}
	
	
	public Object g() throws Exception
	{return list;}
}
