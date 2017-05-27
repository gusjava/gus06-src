package gus06.entity.gus.file.editor.ext.jar.viewer.manifest;

import gus06.framework.*;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.util.jar.Manifest;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20170223";}


	private Service getManifest;
	private Service manifestToString;


	private JTextArea area;
	private JScrollPane scroll;
	

	public EntityImpl() throws Exception
	{
		getManifest = Outside.service(this,"gus.file.jar.manifest.get");
		manifestToString = Outside.service(this,"gus.file.jar.manifest.tostring");
		
		area = new JTextArea();
		area.setEditable(false);
		area.setMargin(new Insets(3,3,3,3));
		
		scroll = new JScrollPane(area);
	}
	
	
	public Object i() throws Exception
	{return scroll;}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj==null)
		{
			area.setText("");
			return;
		}
		Manifest mf = (Manifest) getManifest.t(obj);
		String s = (String) manifestToString.t(mf);
		area.setText(s);
	}
}
