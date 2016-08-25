package gus06.entity.gus.nnn.file.perform.display.infos2;

import gus06.framework.*;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160528";}

	public static final String KEY_RWX = "rwx";
	public static final String KEY_MD5 = "md5";
	public static final String KEY_SHA1 = "sha1";
	public static final String KEY_NAME = "name";
	public static final String KEY_LOCATION = "location";
	public static final String KEY_SIZE = "size";
	public static final String KEY_MIMETYPE = "mimetype";
	public static final String KEY_MIMEHIER = "mimehier";
	public static final String KEY_CHARSET = "charset";
	public static final String KEY_PAGENUMBER = "pagenumber";
	
	public static final String KEY_CREATIONTIME = "creationtime";
	public static final String KEY_LASTMODIFIEDTIME = "lastmodifiedtime";
	public static final String KEY_LASTACCESSTIME = "lastaccesstime";
	
	
	
	private Service infoMap;


	public EntityImpl() throws Exception
	{
		infoMap = Outside.service(this,"gus.file.extract.infomap1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		if(!file.isFile()) throw new Exception("Invalid file: "+file);
		
		String message = buildMessage(file);
		JOptionPane.showMessageDialog(null,message);
	}
	
	
	
	private String buildMessage(File file) throws Exception
	{
		Map map = (Map) infoMap.t(file);
		
		StringBuffer b = new StringBuffer();
		
		b.append("Location: "+		map.get(KEY_LOCATION)+"\n");
		b.append("Name: "+		map.get(KEY_NAME)+"\n");
		b.append("Size: "+		map.get(KEY_SIZE)+"\n");
		b.append("Rights: "+		map.get(KEY_RWX)+"\n");
		b.append("\n");
		b.append("MD5: "+		map.get(KEY_MD5)+"\n");
		b.append("SHA1: "+		map.get(KEY_SHA1)+"\n");
		b.append("\n");
		b.append("Mime type: "+		map.get(KEY_MIMETYPE)+"\n");
		b.append("Mime hier: "+		map.get(KEY_MIMEHIER)+"\n");
		b.append("\n");
		b.append("Charset: "+		map.get(KEY_CHARSET)+"\n");
		b.append("Page nb: "+		map.get(KEY_PAGENUMBER)+"\n");
		b.append("\n");
		b.append("Creation time: "+	map.get(KEY_CREATIONTIME)+"\n");
		b.append("Last modif time: "+	map.get(KEY_LASTMODIFIEDTIME)+"\n");
		b.append("Last access time: "+	map.get(KEY_LASTACCESSTIME)+"\n");
		
		return b.toString();
	}
	
}
