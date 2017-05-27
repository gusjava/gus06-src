package gus06.entity.gus.sys.filetool.ext.javatoolbox1.holder;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20161107";}
	
	
	private Service findRoot;
	
	private JPanel panel;
	
	private Map map;
	private File root;
	

	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		
		panel = new JPanel(new BorderLayout());
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		root = (File) findRoot.t(map);
	}
	

	
	private String get(String key) throws Exception
	{
		if(map==null) throw new Exception("Map not initialized yet");
		if(!map.containsKey(key)) throw new Exception("Key not found inside tool: "+key);
		return (String) map.get(key);
	}
}
