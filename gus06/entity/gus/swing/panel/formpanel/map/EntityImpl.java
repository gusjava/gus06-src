package gus06.entity.gus.swing.panel.formpanel.map;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.HashMap;
import javax.swing.JLabel;


public class EntityImpl implements Entity, I, V, E {

	public String creationDate() {return "20140804";}


	private Service formPanel;
	private Service custLabel;
	
	private HashMap map;
	

	public EntityImpl() throws Exception
	{
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel");
		custLabel = Outside.service(this,"gus.swing.label.cust.popup.menu1");
		
		map = new HashMap();
	}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	
	public void e() throws Exception
	{
		map.clear();
		formPanel.e();
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		boolean sep = key.startsWith("|");
		if(sep) key = key.substring(1);
		
		if(!map.containsKey(key))
		{
			JLabel l = new JLabel();
			map.put(key,l);
			
			custLabel.p(l);
			formPanel.v(key,l);
			
			if(sep) formPanel.v(" ",new JLabel(" "));
		}
		label(key).setText((String) obj);
	}
	
	
	private JLabel label(String key)
	{return (JLabel) map.get(key);}
}
