package gus06.entity.gus.web.httprequest.post.send;

import gus06.framework.*;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;


public class EntityImpl implements Entity, T, V {

	public String creationDate() {return "20141014";}

	public static final String METHOD_POST = "POST";
	public static final String CHARSET = "UTF-8";

	private Map map;
	private String[] auth;
	private String cookie;
	

	private Service setAuth;
	
	public EntityImpl() throws Exception
	{
		setAuth = Outside.service(this,"gus.web.httprequest.auth.basic");
	}

	

	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("map")) {map = (Map) obj;return;}
		if(key.equals("auth")) {auth = (String[]) obj;return;}
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
		
		if(auth!=null) setAuth.p(new Object[]{con,auth[0],auth[1]});
		if(cookie!=null) con.setRequestProperty("Set-Cookie",cookie); 
		
		OutputStream os = con.getOutputStream();
		OutputStreamWriter wr = new OutputStreamWriter(os,CHARSET);
		wr.write(buildInput());
		wr.flush();
	
		InputStreamReader isr = getInputStreamReader(con);
		BufferedReader rd = new BufferedReader(isr);
		
		String line;
		StringBuffer output = new StringBuffer();
		while((line = rd.readLine())!=null) output.append(line+"\n");
		
		wr.close();
		rd.close();
		
		return output.toString().trim();
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
	{return URLEncoder.encode(data,CHARSET);}
	
	
	
	
	private URL toURL(Object obj) throws MalformedURLException
	{
		if(obj instanceof URL) return (URL) obj;
		if(obj instanceof File) return ((File)obj).toURI().toURL();
		return new URL((String)obj);
	}
	
	
	
	
	private InputStreamReader getInputStreamReader(HttpURLConnection con) throws IOException
	{
		String charset = findCharset(con);
		InputStream is = con.getInputStream();  
		if(charset!=null) return new InputStreamReader(is,charset);
		return new InputStreamReader(is,CHARSET);
	}
	
	
	
	private String findCharset(HttpURLConnection con)
	{
		String contentType = con.getContentType();
		if(contentType==null) return null;
		
		contentType = contentType.replaceAll(" ","");
		if(!contentType.contains("charset=")) return null;
		
		return contentType.split("charset=")[1];
	}
}
