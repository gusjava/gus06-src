package gus06.entity.gus.dir.hdd.drivername;

import java.io.File;
import javax.swing.filechooser.FileSystemView;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140910";}

	
	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		File root = findRoot(f);
		
		String name = FileSystemView.getFileSystemView().getSystemDisplayName(root);
		String path = root.getAbsolutePath();
		
		if(path.endsWith(File.separator))
			path = path.substring(0,path.length()-1);
		
		String endPart = " ("+path+")";
		if(name.endsWith(endPart))
			name = name.substring(0,name.length()-endPart.length());
		
		return name;
	}
	
	
	private File findRoot(File f)
	{
		while(!FileSystemView.getFileSystemView().isFileSystemRoot(f))
			f = f.getParentFile();
		return f;
	}
}
