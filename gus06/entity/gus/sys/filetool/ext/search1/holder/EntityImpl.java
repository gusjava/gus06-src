package gus06.entity.gus.sys.filetool.ext.search1.holder;

import gus06.framework.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, I, P, Runnable {

	public String creationDate() {return "20160915";}
	
	
	private Service findRoot;
	private Service buildButton;
	
	private JPanel panel;
	private JButton button;
	
	private Map map;
	private File root;
	
	private Thread t;
	


	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		buildButton = Outside.service(this,"gus.swing.button.build.runnable");
		
		button = (JButton) buildButton.t(this);
		button.setText("search");
		
		panel = new JPanel(new BorderLayout());
		panel.add(button,BorderLayout.SOUTH);
		
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		root = (File) findRoot.t(map);
	}
	
	
	public void run()
	{perform();}
	
	
	
	
	private void perform()
	{
		try
		{
			
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}

	
	
	
	private String get(String key) throws Exception
	{
		if(map==null) throw new Exception("Map not initialized yet");
		if(!map.containsKey(key)) throw new Exception("Key not found inside tool: "+key);
		return (String) map.get(key);
	}
}
