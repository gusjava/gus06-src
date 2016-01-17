package gus06.entity.gus.icon.gui.icondir.dirtomap;

import gus06.framework.*;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140901";}

	public static final FileFilter FILEFILTER = new FileFilter() {
		public boolean accept(File f) {return f.isFile();}
	};
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		File dir = (File) obj;
		File[] ff = dir.listFiles(FILEFILTER);
		if(ff==null) return null;
		
		Map map = new HashMap();
		for(File f:ff) handle(map,f);
		return map;
	}
	
	
	private void handle(Map map, File f) throws Exception
	{
		String name = f.getName();
		if(!name.endsWith(".gif")) throw new Exception("Invalid icon file: "+f);
		
		String id = getId(name);
		Icon icon = getIcon(f);
		
		map.put(id,icon);
	}
	
	
	
	private String getId(String name)
	{return name.substring(0,name.length()-4);}
	
	private Icon getIcon(File f) throws Exception
	{return new ImageIcon(f.toURI().toURL());}
}
