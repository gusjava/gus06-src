package gus06.entity.gus.app.jarfile.md5.c;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140706";}


	private Service appJar;
	private Service md5Hexa;

	public EntityImpl() throws Exception
	{
		appJar = Outside.service(this,"gus.app.jarfile");
		md5Hexa = Outside.service(this,"gus.crypto.hash.md5.hexa");
	}
	
	
	public Object g() throws Exception
	{
		File file = (File) appJar.g();
		return (String) md5Hexa.t(file);
	}
}
