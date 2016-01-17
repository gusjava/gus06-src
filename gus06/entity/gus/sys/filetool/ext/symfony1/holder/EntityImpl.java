package gus06.entity.gus.sys.filetool.ext.symfony1.holder;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150329";}


	private Service tabHolder;
	private Service console;
	private Service entities;



	public EntityImpl() throws Exception
	{
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		console = Outside.service(this,"*gus.sys.filetool.ext.symfony1.holder.console");
		entities = Outside.service(this,"*gus.sys.filetool.ext.symfony1.holder.entities");
		
		tabHolder.v("Entities",entities.i());
		tabHolder.v("Console",console.i());
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		entities.p(obj);
		console.p(obj);
	}
}
