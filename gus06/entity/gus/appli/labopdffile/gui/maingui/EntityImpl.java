package gus06.entity.gus.appli.labopdffile.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150508";}


	private Service chooseFile;
	
	private JPanel panel;
	private JButton button;

	public EntityImpl() throws Exception
	{
		chooseFile = Outside.service(this,"gus.file.choose.open.file.ext.pdf.en");
		
		panel = new JPanel(new BorderLayout());
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
