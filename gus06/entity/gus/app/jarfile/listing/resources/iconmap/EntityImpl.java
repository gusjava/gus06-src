package gus06.entity.gus.app.jarfile.listing.resources.iconmap;

import java.io.File;
import javax.swing.Icon;
import java.util.*;
import gus06.framework.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140910";}
	
	
	private Service resourcesListing;
	private Service getIcon;


	public EntityImpl() throws Exception
	{
		resourcesListing = Outside.service(this,"gus.app.jarfile.listing.resources");
		getIcon = Outside.service(this,"gus.icon.provider");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String start = (String) obj;
		Map map = new HashMap();
		
		List listing = (List) resourcesListing.g();
		for(Object o:listing)
		{
			String path = (String) o;
			if(path.startsWith(start))
			{
				String iconId = findIconId(path);
				map.put(iconId,icon(iconId));
			}
		}
		return map;
	}
	
	
	private String findIconId(String path)
	{
		String[] n = path.split("/");
		String fileName = n[n.length-1];
		
		String[] m = fileName.split("\\.");
		String ext = m[m.length-1];
		return fileName.substring(0,fileName.length()-ext.length()-1);
	}
	
	private Icon icon(String id) throws Exception
	{return (Icon) getIcon.t(id);}
	
}
