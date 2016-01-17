package gus06.entity.gus.app.jarfile.md5;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140704";}

	private Service appJar;
	private Service md5Hexa;
	
	private String md5;

	public EntityImpl() throws Exception
	{
		appJar = Outside.service(this,"gus.app.jarfile");
		md5Hexa = Outside.service(this,"gus.crypto.hash.md5.hexa");
	}
	
	
	public Object g() throws Exception
	{
		if(md5==null) init();
		return md5;
	}
	
	
	private void init() throws Exception
	{
		File file = (File) appJar.g();
		md5 = (String) md5Hexa.t(file);
	}
}
