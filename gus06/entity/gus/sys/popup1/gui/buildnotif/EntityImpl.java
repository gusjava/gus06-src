package gus06.entity.gus.sys.popup1.gui.buildnotif;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161005";}
	
	public static final String KEY_TITLE = "title";
	public static final String KEY_MESSAGE = "message";
	public static final String KEY_EXECUTE = "execute";
	
	public static final Font FONT1 = new Font("Calibri", Font.BOLD, 16);
	public static final Font FONT2 = new Font("Calibri", Font.PLAIN, 16);
	


	private Service labelRender;
	private Service executeOnClick;

	

	public EntityImpl() throws Exception
	{
		labelRender = Outside.service(this,"gus.swing.label.cust2.display");
		executeOnClick = Outside.service(this,"gus.swing.label.cust3.onclick.execute");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map notif = (Map) obj;
		
		String title = (String) get(notif,KEY_TITLE);
		String message = (String) get(notif,KEY_MESSAGE);
		E execute = (E) get(notif,KEY_EXECUTE);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		
		JLabel labelTitle = new JLabel("");
		JLabel labelMessage = new JLabel("");
		
		labelTitle.setFont(FONT1);
		labelMessage.setFont(FONT2);
		
		if(title!=null)
		labelRender.v(title,labelTitle);
		
		if(message!=null)
		labelMessage.setText(message);
		
		if(execute!=null)
		executeOnClick.p(new Object[]{labelTitle,execute});
		
		
		panel.add(labelTitle,BorderLayout.NORTH);
		panel.add(labelMessage,BorderLayout.CENTER);
		
		return panel;
	}
	
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
}
