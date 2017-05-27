package gus06.entity.gus.sys.filetool.ext.idea1.holder;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20160915";}

	public static final String PATH_DATAFILE = "path.datafile";
	public static final String PATH_BACKUPDIR = "path.backupdir";
	public static final String PATH_ICONDIR = "path.icondir";
	

	private Service findRoot;
	private Service editor;
	
	private Map map;
	private File root;



	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		editor = Outside.service(this,"*gus.sys.filetool.ext.idea1.holder.gui1");
	}
	
	public Object i() throws Exception
	{return editor.i();}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		root = (File) findRoot.t(map);
		
		File dataFile = buildDataFile();
		File backupDir = buildBackupDir();
		File iconDir = buildIconDir();
		
		if(backupDir!=null)
		{
			backupDir.mkdirs();
		}
		if(iconDir!=null)
		{
			iconDir.mkdirs();
		}
		
		if(dataFile!=null)
		{
			if(!dataFile.exists()) dataFile.createNewFile();
			editor.p(dataFile);
		}
	}
	
	
	
	private File buildDataFile()
	{
		if(!map.containsKey(PATH_DATAFILE)) return new File(root,"data.txt");
		String path = (String) map.get(PATH_DATAFILE);
		if(path.equals("null")) return null;
		return new File(path);
	}
	
	private File buildBackupDir()
	{
		if(!map.containsKey(PATH_BACKUPDIR)) return new File(root,"backups");
		String path = (String) map.get(PATH_BACKUPDIR);
		if(path.equals("null")) return null;
		return new File(path);
	}
	
	private File buildIconDir()
	{
		if(!map.containsKey(PATH_ICONDIR)) return new File(root,"icons");
		String path = (String) map.get(PATH_ICONDIR);
		if(path.equals("null")) return null;
		return new File(path);
	}
}
