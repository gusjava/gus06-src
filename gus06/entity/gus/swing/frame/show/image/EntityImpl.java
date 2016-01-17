package gus06.entity.gus.swing.frame.show.image;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151001";}


	private Service show;
	private Service newScreen;


	public EntityImpl() throws Exception
	{
		show = Outside.service(this,"gus.swing.frame.show");
		newScreen = Outside.service(this,"factory#gus.swing.panel.screen.image");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object screen = newScreen.g();
		
		((P)screen).p(obj);
		show.p(((I)screen).i());
	}
}
