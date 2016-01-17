package gus06.entity.gus.swing.label.cust3.filedisplay;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.io.File;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140830";}


	private Service fileIcon;
	private Service fileDisplay;

	public EntityImpl() throws Exception
	{
		fileIcon = Outside.service(this,"gus.file.icon.os");
		fileDisplay = Outside.service(this,"gus.dirfile.display");
		
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Invalid data number: "+o.length);
		
		JLabel label = (JLabel) o[0];
		File file = (File) o[1];
		
		if(file!=null)
		{
			label.setText(display(file));
			label.setIcon(icon(file));
		}
		else
		{
			label.setText(" ");
			label.setIcon(null);
		}
	}
	
	
	private Icon icon(File file) throws Exception
	{return (Icon) fileIcon.t(file);}
	
	private String display(File file) throws Exception
	{return (String) fileDisplay.t(file);}
}
