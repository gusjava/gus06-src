package gus06.entity.gus.file.read.image.from.ico;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;
import gus06.framework.*;

public class EntityImpl implements Entity, T {


	public String creationDate() {return "20150616";}


	private Service iconToImage;

	public EntityImpl() throws Exception
	{
		iconToImage = Outside.service(this,"gus.convert.icontoimage");
	}


	public Object t(Object obj) throws Exception
	{
		File file = (File)obj;
		if(!file.exists()) return null;
		Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file);
		return iconToImage.t(icon);
	}
}
