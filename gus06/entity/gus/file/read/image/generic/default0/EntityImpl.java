package gus06.entity.gus.file.read.image.generic.default0;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}



	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(file==null || !file.isFile())
			throw new Exception("Invalid file: "+file);
		
		Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file);
		
		BufferedImage image = new BufferedImage(56,56,BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,56,56);
		if(icon!=null) icon.paintIcon(null,g,20,20);
		g.dispose();
		
		return image;
	}
}
