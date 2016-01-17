package gus06.entity.gus.java.compiler1;

import gus06.framework.*;
import java.io.File;

public class EntityImpl extends S1 implements Entity, V, P, E {

	public String creationDate() {return "20140725";}

	public static final String DEFAULT_TYPE = "2";

	private Service compiler1;
	private Service compiler2;

	private File srcDir;
	private File binDir;
	private File libDir;


	public EntityImpl() throws Exception
	{
		compiler1 = Outside.service(this,"gus.java.compiler.v1");
		compiler2 = Outside.service(this,"gus.java.compiler.v2");

		srcDir = (File) Outside.resource(this,"path#path.dev.srcdir");
		binDir = (File) Outside.resource(this,"path#path.dev.bindir");
		libDir = (File) Outside.resource(this,"path#path.dev.libdir");
	}
	
	
	public void e() throws Exception
	{compile(DEFAULT_TYPE,null);}


	public void p(Object obj) throws Exception
	{compile(DEFAULT_TYPE,(F) obj);}
	
	
	public void v(String key, Object obj) throws Exception
	{compile(key,(F) obj);}



	private void compile(String type, F filter) throws Exception
	{
		start();
		
		try
		{
			Service s = find(type);
			s.v("srcDir",srcDir);
			s.v("binDir",binDir);
			s.v("libDir",libDir);
			s.v("filter",filter);
			s.e();
		}
		finally {end();}
	}


	private Service find(String type) throws Exception
	{
		if(type.equals("1")) return compiler1;
		if(type.equals("2")) return compiler2;
		throw new Exception("Unknown compiler type: "+type);
	}
	
	
	
	
	private void start()
	{send(this,"start()");}
	
	private void end()
	{send(this,"end()");}
}
