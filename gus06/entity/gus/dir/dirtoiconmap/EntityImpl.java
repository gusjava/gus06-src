package gus06.entity.gus.dir.dirtoiconmap;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150614";}
	
	
	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		
		Map map = new HashMap();
		File[] ff = dir.listFiles();
		if(ff!=null) for(File f:ff) handle(map,f);
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
