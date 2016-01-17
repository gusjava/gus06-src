package gus06.entity.gus.file.editor.ext.properties.form;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140831";}


	private Service formPanel;
	
	private Map map;
	
	private JTextField field_key;
	private JTextField field_value;

	public EntityImpl() throws Exception
	{
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel");
		
		field_key = new JTextField();
		field_value = new JTextField();
		
		formPanel.v("Key",field_key);
		formPanel.v("Value",field_value);
		
		field_key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{validateKey();}
		});
		field_value.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{validateValue();}
		});
	}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
	}
	
	
	private void validateKey()
	{
		if(map==null) return;
		field_value.requestFocusInWindow();
	}
	
	
	private void validateValue()
	{
		if(map==null) return;
		map.put(field_key.getText(),field_value.getText());
		field_key.setText("");
		field_value.setText("");
		field_key.requestFocusInWindow();
	}
}
