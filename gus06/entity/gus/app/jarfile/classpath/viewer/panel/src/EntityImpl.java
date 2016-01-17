package gus06.entity.gus.app.jarfile.classpath.viewer.panel.src;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140829";}

	
	private Service srcPanel;
	private Service findSrc;


	private String name;
	
	
	
	public EntityImpl() throws Exception
	{
		srcPanel = Outside.service(this,"*gus.data.viewer.string.src.java");
		findSrc = Outside.service(this,"gus.app.jarfile.classpath.findsrc");
	}
	
	
	public Object i() throws Exception
	{return srcPanel.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		name = (String) obj;
		String src = (String) findSrc.t(name);
		srcPanel.p(src);
	}
}
