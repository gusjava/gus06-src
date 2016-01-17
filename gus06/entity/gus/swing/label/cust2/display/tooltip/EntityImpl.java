package gus06.entity.gus.swing.label.cust2.display.tooltip;

import javax.swing.Icon;
import javax.swing.JLabel;
import gus06.framework.*;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150613";}



	private Service iconProvider;
	
	private Icon icon(String id) throws Exception
	{return (Icon) iconProvider.t(id);}
	
	public EntityImpl() throws Exception
	{iconProvider = Outside.service(this,"gus.icon.provider");}



	public void v(String key, Object obj) throws Exception
	{repaintLabel((JLabel)obj,key);}
	
	
	
	private void repaintLabel(JLabel label, String info) throws Exception
	{
		if(info==null || info.equals(""))
		{
			label.setText(" ");
			label.setIcon(null);
			label.setToolTipText(null);
		}
		else if(info.contains("#"))
		{
			String[] m = info.split("#",2);
			label.setText(m[1]);
			label.setToolTipText(m[1]);
			label.setIcon(icon(m[0]));
		}
		else
		{
			label.setText(info);
			label.setToolTipText(info);
			label.setIcon(null);
		}
	}
}
