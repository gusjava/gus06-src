package gus06.entity.gus.security.askinfo.password1;

import gus06.framework.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150613";}

	private JFrame mainFrame;
	private PasswordDialog dialog;
	private ImageIcon icon;
	
	
	public EntityImpl() throws Exception
	{
		mainFrame = (JFrame) Outside.resource(this,"mainframe");
		icon = (ImageIcon) Outside.resource(this,"icon#SECURITY_password");
		
		dialog = new PasswordDialog(mainFrame);
		if(icon!=null) dialog.setIconImage(icon.getImage());
	}

	public Object g() throws Exception
	{
		dialog.setVisible(true);
		return dialog.getPassword();
	}
}