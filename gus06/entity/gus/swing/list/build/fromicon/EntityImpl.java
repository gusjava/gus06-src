package gus06.entity.gus.swing.list.build.fromicon;

import gus06.framework.*;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}


	private Service renderer;
	
	public EntityImpl() throws Exception
	{renderer = Outside.service(this,"gus.swing.list.cust.renderer1");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		renderer.v("icon",obj);
		renderer.v("color",null);
		renderer.p(list);
		
		return list;
	}
}
