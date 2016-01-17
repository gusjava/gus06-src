package gus06.entity.gus.appli.baseaccess1.gui.type.jdbc;

import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150808";}

	private Service base;
	private Service gui;

	public EntityImpl() throws Exception
	{
		base = Outside.service(this,"gus.sys.base1.holder.jdbc");
		gui = Outside.service(this,"*gus.sys.base1.gui.maingui1");
		
		gui.p(base);
	}
	
	public Object i() throws Exception
	{return gui.i();}
}
