package gus06.entity.gus.java.compiler.v2.perform1;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161107";}
	
	public static final String KEY_SRCDIR = "src";
	public static final String KEY_BINDIR = "bin";
	public static final String KEY_LIBDIR = "lib";
	public static final String KEY_JDKDIR = "jdk";
	public static final String KEY_FILTER = "filter";
	public static final String KEY_OUTPUT = "output";


	private Service compiler;
	
	public EntityImpl() throws Exception
	{
		compiler = Outside.service(this,"gus.java.compiler.v2");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		File srcDir = (File) get1(map,KEY_SRCDIR);
		File binDir = (File) get1(map,KEY_BINDIR);
		
		compiler.v("srcDir",srcDir);
		compiler.v("binDir",binDir);
		
		File libDir = (File) get0(map,KEY_LIBDIR);
		File jdkDir = (File) get0(map,KEY_JDKDIR);
		F filter = (F) get0(map,KEY_FILTER);
		Object output = get0(map,KEY_OUTPUT);
		
		compiler.v("libDir",libDir);
		compiler.v("jdkDir",jdkDir);
		compiler.v("filter",filter);
		compiler.v("output",output);
		
		compiler.e();
	}
	
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found inside map: "+key);
		return map.get(key);
	}
	
	private Object get0(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
}
