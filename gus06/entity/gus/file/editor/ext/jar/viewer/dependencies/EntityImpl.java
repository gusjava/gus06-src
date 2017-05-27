package gus06.entity.gus.file.editor.ext.jar.viewer.dependencies;

import gus06.framework.*;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.util.jar.Manifest;
import java.util.List;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20170223";}


	private Service find;
	private Service listToString;


	private JTextArea area;
	private JScrollPane scroll;
	

	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.file.jar.imports.listing.dep");
		listToString = Outside.service(this,"gus.tostring.list");
		
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
		List list = (List) find.t(obj);
		String s = (String) listToString.t(list);
		area.setText(s);
	}
}
