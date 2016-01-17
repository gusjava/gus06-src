package gus06.entity.gus.web.httprequest.post.download;

import gus06.framework.*;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;


public class EntityImpl implements Entity, T, V {

	public String creationDate() {return "20150318";}
	
	
	public static final String METHOD_POST = "POST";


	private Service getFileName;
	
	private File storeDir;
	private Map map;
	private String cookie;
	
	
	public EntityImpl() throws Exception
	{
		getFileName = Outside.service(this,"gus.web.httprequest.getfilename");
		storeDir = (File) Outside.resource(this,"defaultdir");
	}

	

	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("map")) {map = (Map) obj;return;}
		if(key.equals("cookie")) {cookie = (String) obj;return;}
		
		throw new Exception("Unknown key: "+key);
	}



	public Object t(Object obj) throws Exception
	{
		URL url = toURL(obj);
		if(map==null) throw new Exception("Parameter map has not been initialized yet");
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(METHOD_POST);
		con.setDoOutput(true);
		if(cookie!=null) con.setRequestProperty("Set-Cookie",cookie); 
		
		OutputStream os = con.getOutputStream();
		OutputStreamWriter wr = new OutputStreamWriter(os,"UTF-8");
		wr.write(buildInput());
		wr.flush();
		
		String fileName = (String) getFileName.t(con);
		File file = new File(storeDir,fileName);
		
		InputStream is = con.getInputStream();
		FileOutputStream fos = new FileOutputStream(file);  
        	
		int b;
        	while((b = is.read())!=-1)
        	{
        		fos.write(b);
        		Thread.yield();
        	}    
        	is.close();
        	fos.close();
        	con.disconnect();

        	if(file.length()==0) throw new Exception("Empty file for url: "+url);
		return file;
	}

	
	
	
	private String buildInput() throws Exception
	{
		StringBuffer b = new StringBuffer();
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = (String) map.get(key);
			append(b,key,value);
		}
		return b.toString();
	}
	
	
	
	private void append(StringBuffer b, String key, String value) throws Exception
	{
		try
		{
			String bloc = format(key)+"="+format(value);
			if(b.length()>0) b.append("&");
			b.append(bloc);
		}
		catch(Exception e)
		{
			String message = "Building input failed for key="+key+" and value="+value;
			throw new Exception(message,e);
		}
	}

	
	private String format(String data) throws Exception
	{return URLEncoder.encode(data,"UTF-8");}
	
	
	
	
	private URL toURL(Object obj) throws MalformedURLException
	{
		if(obj instanceof URL) return (URL) obj;
		if(obj instanceof File) return ((File)obj).toURI().toURL();
		return new URL((String)obj);
	}
}
