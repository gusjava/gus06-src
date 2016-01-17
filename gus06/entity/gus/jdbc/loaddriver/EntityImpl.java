package gus06.entity.gus.jdbc.loaddriver;

import gus06.framework.*;
import java.io.PrintStream;
import java.sql.Driver;
import java.sql.DriverManager;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141006";}

	private PrintStream out;

	public EntityImpl() throws Exception
	{out = (PrintStream) Outside.resource(this,"sysout");}
	
	
	
	public void p(Object obj) throws Exception
	{
		String path = (String) obj;
		
		Class driverClass = Class.forName(path);
		Driver driver = (Driver) driverClass.newInstance();
		DriverManager.registerDriver(driver);
		
		int major = driver.getMajorVersion();
		int minor = driver.getMinorVersion();
		out.println("JDBC driver loaded: "+path+" ["+major+"-"+minor+"]");
	}
}
