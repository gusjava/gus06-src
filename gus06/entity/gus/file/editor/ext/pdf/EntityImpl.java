package gus06.entity.gus.file.editor.ext.pdf;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.File;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20150617";}


	private Service screen;
	private Service readImage;

	private File file;


	public EntityImpl() throws Exception
	{
		screen = Outside.service(this,"*gus.swing.panel.screen.image");
		readImage = Outside.service(this,"gus.file.read.image.from.pdf");
	}
	
	
	public Object i() throws Exception
	{return screen.i();}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file!=null && file.exists())
			screen.p(readImage.t(file));
		else screen.p(null);
	}
}
