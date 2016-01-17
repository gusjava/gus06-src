package gus06.entity.gus.appdev.updatebuild.buildprop;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140907";}

	
	public static final String KEY = "jar.buildtime";
	
	private Service now;
	

	public EntityImpl() throws Exception
	{now = Outside.service(this,"gus.time.now");}
	
	
	public Object g() throws Exception
	{
		Properties p = new Properties();
		p.setProperty(KEY,(String) now.g());
		return p;
	}
}
