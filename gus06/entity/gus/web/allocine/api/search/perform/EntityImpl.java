package gus06.entity.gus.web.allocine.api.search.perform;

import gus06.framework.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141010";}


	public static final String URLROOT = "http://api.allocine.fr/rest/v3/search";
	public static final String USER_AGENT = "Dalvik/1.6.0 (Linux; U; Android 4.2.2; Nexus 4 Build/JDQ39E)";
	public static final String PARTNER_KEY = "100043982026";
	public static final String SECRET_KEY = "29d185d98c984a359e6e6f26a0474269";
	
	
	
	private SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	private String today() {return yyyyMMdd.format(new Date());}
	
	private MessageDigest md = MessageDigest.getInstance("SHA1");
	
	

	private Service buildBase64;
	
	public EntityImpl() throws Exception
	{buildBase64 = Outside.service(this,"gus.tostring.bytetobase64");}



	public Object t(Object obj) throws Exception
	{
		String input = (String) obj;
		
		String[] n = input.split("\\|",2);
		String search = n[0];
		String page = n.length==2?n[1]:null;
		
		String params = buildParams(search,page);
		String sig = encrypt(SECRET_KEY+params);
		String url = URLROOT+"?"+params+"&sig="+sig;
		
		URLConnection con = new URL(url).openConnection();
		con.setRequestProperty("User-Agent",USER_AGENT);
		con.connect();
		
		return getContent(con);
	}
	
	
	
	
	private String buildParams(String search, String page) throws Exception
	{
		StringBuffer b = new StringBuffer();
		
		b.append("partner="+PARTNER_KEY);
		b.append("&q="+encode(search));
		if(page!=null) b.append("&page="+page);
		b.append("&format=json&filter=movie");
		b.append("&sed="+today());
		
		return b.toString();
	}

	
	
	private String encrypt(String str) throws Exception
	{
		md.update(str.getBytes());
		byte[] raw = md.digest();
		md.reset();
		
		return encode(buildBase64(raw));
	}
	
	
	
	private String buildBase64(byte[] raw) throws Exception
	{return (String) buildBase64.t(raw);}
	
	
	private String encode(String s) throws Exception
	{return URLEncoder.encode(s,"UTF-8");}
	
	
	
	
	private String getContent(URLConnection con) throws IOException
	{
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		StringBuffer buffer = new StringBuffer();
		int b;
		while((b = isr.read())!=-1)
		{buffer.append((char)b);}
		isr.close();
		
		if(con instanceof HttpURLConnection)
			((HttpURLConnection)con).disconnect();
		return buffer.toString();
	}
}
