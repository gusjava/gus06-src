package gus06.entity.gus.java.compiler.v2;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, E, V {

	public String creationDate() {return "20140724";}


	private Service findJavac;
	private Service buildListing;
	private Service debugScripts;
	private Service handleProcess;
	
	private File srcDir;
	private File binDir;
	private File libDir;
	private F filter;
	

	public EntityImpl() throws Exception
	{
		findJavac = Outside.service(this,"gus.java.jdk.javacfile");
		buildListing = Outside.service(this,"gus.java.compiler.buildlisting");
		debugScripts = Outside.service(this,"gus.java.compiler.debug.scripts");
		handleProcess = Outside.service(this,"gus.java.compiler.handleprocess.is");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("srcDir")) {srcDir = (File) obj;return;}
		if(key.equals("binDir")) {binDir = (File) obj;return;}
		if(key.equals("libDir")) {libDir = (File) obj;return;}
		if(key.equals("filter")) {filter = (F) obj;return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void e() throws Exception
	{
		binDir.mkdirs();
		libDir.mkdirs();

		if(!srcDir.isDirectory()) throw new Exception("Src directory not found: "+srcDir);
		if(!binDir.isDirectory()) throw new Exception("Bin directory not found: "+binDir);
		if(!libDir.isDirectory()) throw new Exception("Lib directory not found: "+libDir);

		File javacFile = (File) findJavac.g();
		File listingFile = (File) buildListing.t(new Object[]{srcDir,filter});

		debugScripts.p(new File[]{srcDir,binDir,javacFile,listingFile});

		String javacPath = javacFile.getAbsolutePath();
		String listingPath = listingFile.getAbsolutePath();
		String srcPath = srcDir.getAbsolutePath();
		String binPath = binDir.getAbsolutePath();
		String libPath = libDir.getAbsolutePath();

		String[] cmd = new String[]{javacPath,"-classpath",libPath+"/*","-sourcepath",srcPath,"-d",binPath,"@"+listingPath};
        
        
		ProcessBuilder pb = new ProcessBuilder(cmd);
		pb.redirectErrorStream(true);

		Process pr = pb.start();
		handleProcess.p(pr);
	}
}
