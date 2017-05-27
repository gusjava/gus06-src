package gus06.manager.gus.gyem.m036.t.entity.class1.load.main;

import java.net.URL;
import java.net.URLClassLoader;
import gus06.framework.*;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {


	private ClassLoader cl;

	
	public Object g() throws Exception
	{
		if(cl==null) init();
		update(findNewUrls());
		return cl;
	}
	
	private void init() throws Exception
	{
		cl = ClassLoader.getSystemClassLoader();
		update(findInitUrls());
	}
	
	
	private void update(URL[] urls)
	{if(urls!=null) cl = new URLClassLoader(urls,cl);}
	
	private URL[] findInitUrls() throws Exception
	{return (URL[]) ((G) module(M037_G_ENTITY_CLASS1_LOAD_MAIN_INITURLS)).g();}
	
	private URL[] findNewUrls() throws Exception
	{return (URL[]) ((G) module(M038_G_ENTITY_CLASS1_LOAD_MAIN_NEWURLS)).g();}
}