package gus06.entity.gus.sys.drawingpanel1.screen;

import gus06.framework.*;

public class EntityImpl implements Entity, P, I, V {

	public String creationDate() {return "20170425";}


	private Service screen;
	private Service drawer;
	
	public EntityImpl() throws Exception
	{
		screen = Outside.service(this,"*gus.swing.panel.screen.drawn");
		drawer = Outside.service(this,"*gus.sys.drawingpanel1.drawer");
	}
	
	
	public Object i() throws Exception
	{return screen.i();}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("background")) {drawer.v("background",obj);return;}
		if(key.equals("foreground")) {drawer.v("foreground",obj);return;}
		if(key.equals("dimension")) {drawer.v("dimension",obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	public void p(Object obj) throws Exception
	{
		drawer.v("data",obj);
		screen.p(drawer);
	}
	
}
