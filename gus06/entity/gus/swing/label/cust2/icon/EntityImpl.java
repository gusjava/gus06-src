package gus06.entity.gus.swing.label.cust2.icon;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.JLabel;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140803";}


	private Service iconProvider;

	public EntityImpl() throws Exception
	{iconProvider = Outside.service(this,"gus.icon.provider");}
	
	
	public void v(String key, Object obj) throws Exception
	{perform(key,(JLabel) obj);}
	
	
	private void perform(String info, JLabel label) throws Exception
	{label.setIcon(icon(info));}
	
	
	private Icon icon(String id) throws Exception
	{return (Icon) iconProvider.t(id);}
}
