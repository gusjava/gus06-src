package gus06.entity.gus.dirfile.find.root;

import java.io.File;
import javax.swing.filechooser.FileSystemView;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161224";}


	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		return findRoot(f);
	}
	
	
	
	private File findRoot(File f)
	{
		while(!FileSystemView.getFileSystemView().isFileSystemRoot(f))
			f = f.getParentFile();
		return f;
	}
}
