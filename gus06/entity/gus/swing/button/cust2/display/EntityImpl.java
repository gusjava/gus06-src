package gus06.entity.gus.swing.button.cust2.display;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.JButton;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140908";}


	private Service iconProvider;

	public EntityImpl() throws Exception
	{iconProvider = Outside.service(this,"gus.icon.provider");}
	
	
	public void v(String key, Object obj) throws Exception
	{perform(key,(JButton) obj);}
	
	
	private void perform(String info, JButton button) throws Exception
	{
		if(info==null || info.equals(""))
		{
			button.setText(" ");
			button.setIcon(null);
		}
		else if(info.contains("#"))
		{
			String[] m = info.split("#",2);
			button.setText(m[1]);
			button.setIcon(icon(m[0]));
		}
		else
		{
			button.setText(info);
			button.setIcon(null);
		}
	}
	
	private Icon icon(String id) throws Exception
	{return (Icon) iconProvider.t(id);}
}
