package gus06.entity.gus.swing.label.cust3.filedisplay2;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.io.File;
import java.awt.Font;
import java.awt.Color;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141209";}


	private Service fileIcon;
	private Service fileDisplay;
	private Service fileColor;

	public EntityImpl() throws Exception
	{
		fileIcon = Outside.service(this,"gus.file.icon.os");
		fileDisplay = Outside.service(this,"gus.dirfile.display");
		fileColor = Outside.service(this,"gus.file.findcolor1");
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
        		label.setForeground(color(file));
        		label.setFont(findFont(file,label.getFont()));
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
	
	
	private Color color(File file) throws Exception
	{return (Color) fileColor.t(file);}
	
	
	
	private Font findFont(File file, Font f)
	{
		if(!file.exists() || file.canWrite())
			return f.deriveFont(Font.PLAIN);
		return f.deriveFont(Font.ITALIC);
	}
}
