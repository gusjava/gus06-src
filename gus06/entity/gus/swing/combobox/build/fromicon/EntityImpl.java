package gus06.entity.gus.swing.combobox.build.fromicon;

import gus06.framework.*;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150920";}


	private Service renderer;
	
	public EntityImpl() throws Exception
	{renderer = Outside.service(this,"gus.swing.combobox.cust.renderer1");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		JComboBox combo = new JComboBox();
		
		renderer.v("icon",obj);
		renderer.v("color",null);
		renderer.p(combo);
		
		return combo;
	}
}
