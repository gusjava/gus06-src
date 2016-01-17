package gus06.entity.gus.file.editor.ext.jar.entryviewer.panel.gif;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140809";}

	private Service isToByteArray;
	private JLabel label;
	
	public EntityImpl() throws Exception
	{
		isToByteArray = Outside.service(this,"gus.io.transfer.tobytearray");
		label = new JLabel(" ");
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	
	public void p(Object obj) throws Exception
	{
		InputStream is = (InputStream) obj;
		byte[] data = (byte[]) isToByteArray.t(is);
		label.setIcon(new ImageIcon(data));
	}
}
