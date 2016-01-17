package gus06.manager.gus.gyem.m037.g.entity.class1.load.main.initurls;

import java.util.Map;
import java.net.URL;
import gus06.framework.G;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {



	public Object g() throws Exception
	{
		String value = getValue(PROP_APPCLURLS);
		if(value==null) return null;
		
		String[] n = value.split(";");
		URL[] urls = new URL[n.length];
		
		for(int i=0;i<n.length;i++)
		urls[i] = findURL(n[i]);
		
		return urls;
	}
	
	
	
	private String getValue(String key) throws Exception
	{
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		if(prop==null || !prop.containsKey(key)) return null;
		return (String) prop.get(key);
	}
	
	
	
	private URL findURL(String path) throws Exception
	{
		return (URL) ((T) module(M009_T_INSIDE)).t("url.api/"+path);
	}
}