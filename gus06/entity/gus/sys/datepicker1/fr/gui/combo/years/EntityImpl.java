package gus06.entity.gus.sys.datepicker1.fr.gui.combo.years;

import gus06.framework.*;
import javax.swing.JComboBox;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160616";}


	private Service clickNext;
	private Service custWhite;


	private JComboBox combo;

	public EntityImpl() throws Exception
	{
		clickNext = Outside.service(this,"gus.swing.combobox.cust.clicknext");
		custWhite = Outside.service(this,"gus.swing.combobox.cust.white");
		
		combo = new JComboBox();
		
		for(int i=1900;i<2050;i++)
		combo.addItem(new Integer(i));
		
		custWhite.p(combo);
		clickNext.p(combo);
	}
	
	
	public Object i() throws Exception
	{return combo;}
}
