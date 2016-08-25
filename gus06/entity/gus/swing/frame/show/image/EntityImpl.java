package gus06.entity.gus.swing.frame.show.image;

import gus06.framework.*;

public class EntityImpl implements Entity, T, V, P {

	public String creationDate() {return "20151001";}


	private Service show;
	private Service newScreen;


	public EntityImpl() throws Exception
	{
		show = Outside.service(this,"gus.swing.frame.show");
		newScreen = Outside.service(this,"factory#gus.swing.panel.screen.image");
	}
	
	
	
	private Object comp(Object obj) throws Exception
	{
		Object screen = newScreen.g();
		((P)screen).p(obj);
		return ((I)screen).i();
	}
	
	
	public void p(Object obj) throws Exception
	{show.p(comp(obj));}
	
	public void v(String key, Object obj) throws Exception
	{show.v(key,comp(obj));}
	
	public Object t(Object obj) throws Exception
	{return show.t(comp(obj));}
}
