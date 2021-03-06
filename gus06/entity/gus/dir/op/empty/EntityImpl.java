package gus06.entity.gus.dir.op.empty;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}
	
	
	public void p(Object obj) throws Exception
	{
		File dir = (File) obj;
		if(!dir.isDirectory())
			throw new Exception("Invalid directory: "+dir);

		emptyDir(dir);
	}

	
	private void emptyDir(File dir) throws Exception
	{
		File[] ff = dir.listFiles();
		for(File f:ff)
		{
			if(f.isFile()) deleteFile(f);
			else deleteDir(f);
		}
	}
	
	
	private void deleteFile(File file) throws Exception
	{
		boolean r = file.delete();
		if(!r) throw new Exception("File could not be deleted: "+file);
	}
	
	private void deleteDir(File dir) throws Exception
	{
		emptyDir(dir);
		boolean r = dir.delete();
		if(!r) throw new Exception("Dir could not be deleted: "+dir);
	}

}
