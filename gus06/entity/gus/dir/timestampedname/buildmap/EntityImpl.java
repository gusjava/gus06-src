package gus06.entity.gus.dir.timestampedname.buildmap;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170109";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof File)
			return buildMap((File) obj);
		
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		String value = (String) o[1];
		
		return buildMap(dir,value);
	}
	
	
	
	private Map buildMap(File dir)
	{
		String regex = "\\d\\d\\d\\d\\d\\d\\d\\d_\\d\\d\\d\\d\\d\\d_.+";
		return buildFromRegex(dir,regex);
	}
	
	private Map buildMap(File dir, String value)
	{
		String regex = "\\d\\d\\d\\d\\d\\d\\d\\d_\\d\\d\\d\\d\\d\\d_\\Q"+value+"\\E";
		return buildFromRegex(dir,regex);
	}
	
	
	private Map buildFromRegex(File dir, String regex)
	{	
		File[] ff = dir.listFiles();
		Map map = new HashMap();
		
		for(File f:ff)
		{
			String name = f.getName();
			if(name.matches(regex))
			{
				String timeStamp = name.substring(0,15);
				map.put(timeStamp,f);
			}
		}
		return map;
	}
}
