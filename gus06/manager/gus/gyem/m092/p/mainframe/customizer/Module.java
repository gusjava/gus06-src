package gus06.manager.gus.gyem.m092.p.mainframe.customizer;

import java.util.Map;
import javax.swing.JFrame;
import java.awt.Dimension;
import gus06.framework.P;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements P {

	public void p(Object obj) throws Exception
	{
		JFrame frame = (JFrame) obj;
		
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		
		String title = get(prop,PROP_APPTITLE,DEFAULT_APPTITLE);
		String size = get(prop,PROP_APPSIZE,DEFAULT_APPSIZE);

		frame.setTitle(title);
		frame.setSize(dim(size));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	private String get(Map prop, String key, String defaultValue)
	{
		if(!prop.containsKey(key)) return defaultValue;
		return (String) prop.get(key);
	}


	private Dimension dim(String size)
	{
		String[] n = size.split(" ");
		return new Dimension(i_(n[0]),i_(n[1]));
	}


	private int i_(String s)
	{return Integer.parseInt(s);}
}