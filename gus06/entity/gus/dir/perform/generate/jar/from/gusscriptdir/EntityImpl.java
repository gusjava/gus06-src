package gus06.entity.gus.dir.perform.generate.jar.from.gusscriptdir;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170401";}
	
	public static final String PACKAGE_ROOT = "gus06/resource/gus/gyem/";
	public static final String FILENAME_PROP = "prop.properties";
	public static final String DIRNAME_ROOT = "root";


	private Service jarModifier;
	private Service buildProp;
	private Service findFilesGus;
	private Service findFilesGif;
	private Service readProp;
	private Service buildPaths;

	public EntityImpl() throws Exception
	{
		jarModifier = Outside.service(this,"gus.app.jarfile.modifier1");
		buildProp = Outside.service(this,"gus.file.perform.generate.jar.from.gusscript.prop");
		findFilesGus = Outside.service(this,"gus.dir.listing0.ext.gus");
		findFilesGif = Outside.service(this,"gus.dir.listing0.ext.gif");
		readProp = Outside.service(this,"gus.file.read.properties");
		buildPaths = Outside.service(this,"gus.dir.listing.dirtopathmap");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		File jarFile1 = (File) o[1];
		
		
		Map map = new HashMap();
		
		Properties prop = (Properties) buildProp.g();
		
		File pFile = new File(dir,FILENAME_PROP);
		Properties prop1 = (Properties) readProp.t(pFile);
		if(prop1!=null) prop.putAll(prop1);
		
		map.put(PACKAGE_ROOT+"prop",prop);
		
		File[] scripts = (File[]) findFilesGus.t(dir);
		for(File script : scripts)
		{
			String path = PACKAGE_ROOT+"script/"+script.getName();
			map.put(path,script);
		}
		
		File[] gifs = (File[]) findFilesGif.t(dir);
		for(File gif : gifs)
		{
			String path = PACKAGE_ROOT+"icon/"+gif.getName();
			map.put(path,gif);
		}
		
		File rootDir = new File(dir,DIRNAME_ROOT);
		if(rootDir.isDirectory())
		{
			Map m = (Map) buildPaths.t(rootDir);
			Iterator it = m.keySet().iterator();
			while(it.hasNext())
			{
				String path0 = (String) it.next();
				File f = (File) m.get(path0);
				
				path0 = path0.replace(File.separator,"/");
				if(path0.startsWith("/")) path0 = path0.substring(1);
				
				String path = PACKAGE_ROOT+path0;
				map.put(path,f);
			}
		}
		
		jarModifier.p(new Object[]{jarFile1,map});
	}
}
