package gus06.manager.gus.gyem.m009.t.inside;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import gus06.framework.T;
import gus06.framework.R;
import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements T, R, G {


	public Object g() throws Exception
	{return ((G) module(M010_G_INSIDE_ROOT)).g();}
	
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	
	public Object r(String key) throws Exception
	{
		if(!key.contains(".")) throw new Exception("Unknown key: ["+key+"]");

		String[] n = key.split("\\.",2);
		String type = n[0];
		String path = g()+n[1];
		return findInside(type,path);
	}



	
	
	private Object findInside(String type, String path) throws Exception
	{
		if(type.equals("url"))		return url(path);
		if(type.equals("stream"))	return stream(path);
		if(type.equals("prop"))		return prop(path);
		if(type.equals("txt"))		return txt(path);
		if(type.equals("list"))		return list(path);
        
		throw new Exception("Unknown inside type: ["+type+"]");
	}
	
	
	private URL url(String path)
	{return getClass().getResource(path);}
    
    
	private InputStream stream(String path) throws Exception
	{
		if(!checkDone) check(path);
		return getClass().getResourceAsStream(path);
	}
    
	private Properties prop(String path) throws Exception
	{
		InputStream is = stream(path);
		if(is==null) return null;
		
		Properties p = new Properties();
		p.load(is);
		is.close();
		return p;
	}
    
	private String txt(String path) throws Exception
	{
		InputStream is = stream(path);
		if(is==null) return null;
        
		StringBuffer b = new StringBuffer();
		int c;
		while((c=is.read())!=-1)
		b.append((char)c);
		is.close();
		return b.toString();
	}
    
	private List list(String path) throws Exception
	{
		String text = txt(path);
		if(text==null) return null;
		return Arrays.asList(text.split("\n"));
	}
	
	
	
	
	
    /*
     * If the application path contains a exclamation marks '!',
     * the following sun class: sun.net.www.protocol.jar.JarURLConnection$JarURLInputStream
     * will not be successfully instantiated during the getResourceAsStream call
     */
    private boolean checkDone = false;
    
    private void check(String path) throws Exception
    {
    	URL url = getClass().getResource(path);
    	if(url==null) return;
    	if(getClass().getResourceAsStream(path)==null)
    		throw new Exception("Unable to handle jar internal URLs due to exclamation mark confusion :"+
    				"\ntroubling url example: ["+url+"]"+
    				"\nPlease remove all exclamation marks '!' from the application path");
    	checkDone = true;
    }
}