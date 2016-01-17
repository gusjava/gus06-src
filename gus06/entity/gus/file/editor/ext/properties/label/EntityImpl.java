package gus06.entity.gus.file.editor.ext.properties.label;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, I, P, ActionListener {

	public String creationDate() {return "20140831";}


	private Map map;
	
	private JLabel label;

	

	public EntityImpl() throws Exception
	{
		label = new JLabel(" ");
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(map!=null) throw new Exception("Map already initialized");
		map = (Map) obj;
		((S) map).addActionListener(this);
		updateGui();
	}
	
	
	
	public void actionPerformed(ActionEvent evt)
	{updateGui();}
	
	
	private void updateGui()
	{label.setText(" Number: "+map.size());}
}
