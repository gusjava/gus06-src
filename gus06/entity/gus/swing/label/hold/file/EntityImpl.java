package gus06.entity.gus.swing.label.hold.file;

import java.io.File;

import gus06.framework.*;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140723";}

	private Service getIcon;
	private JLabel label;
	private File file;

	public EntityImpl() throws Exception
	{
		getIcon = Outside.service(this,"gus.file.icon.os");
		label = new JLabel(" ");
		label.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file==null)
		{
			label.setIcon(null);
			label.setToolTipText(null);
			label.setText(" ");
		}
		else
		{
			label.setIcon(icon(file));
			label.setText(file.getName());
			label.setToolTipText(file.getAbsolutePath());
		}
	}

	
	
	private Icon icon(File file) throws Exception
	{return (Icon) getIcon.t(file);}
}
