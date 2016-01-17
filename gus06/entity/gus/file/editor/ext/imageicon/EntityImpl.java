package gus06.entity.gus.file.editor.ext.imageicon;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.File;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140723";}

	private JLabel label;

	public EntityImpl() throws Exception
	{
		label = new JLabel(" ");
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		ImageIcon icon = file==null?null:new ImageIcon(file.toURI().toURL());
		label.setIcon(icon);
	}
}
