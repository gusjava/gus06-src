package gus06.entity.gus.sys.runtask1.input.dir.gui;

import gus06.framework.*;

public class EntityImpl implements Entity, I, G {

	public String creationDate() {return "20150921";}


	private Service tab;


	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
	}
	
	
	public Object i() throws Exception
	{return tab;}
	
	
	public Object g() throws Exception
	{
		return null;
	}
}
