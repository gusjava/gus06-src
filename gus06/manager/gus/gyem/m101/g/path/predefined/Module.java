package gus06.manager.gus.gyem.m101.g.path.predefined;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	private Map map;
	
	public Object g() throws Exception
	{
		if(map==null) init();
		return map;
	}
	
	
	private void init() throws Exception
	{
		map = new HashMap();
		fromSystemProperties();
		fromSystemEnv();
	}
	
	
	
	private void fromSystemProperties()
    {
        Iterator it = System.getProperties().keySet().iterator();
        while(it.hasNext())
        {
            String key = (String)it.next();
            String value = System.getProperty(key);
            fromLine("sys."+key,value);
        }
    }
    
    
    private void fromSystemEnv()
    {
        Iterator it = System.getenv().keySet().iterator();
        while(it.hasNext())
        {
            String key = (String)it.next();
            String value = System.getenv(key);
            fromLine("env."+key,value);
        }
    }
    
    
    
    private void fromLine(String key, String value)
    {
        String[] paths = value.split(File.pathSeparator);
        
        for(int i=0;i<paths.length;i++)
        {
            String path = paths[i];
            if(path.length()>0)
            {
                File f = new File(path);
                if(f.exists())
                {
                    if(paths.length==1) map.put("path."+key,f);
                    else map.put("path."+key+"."+i,f);
                }
            }
        }
    }
}