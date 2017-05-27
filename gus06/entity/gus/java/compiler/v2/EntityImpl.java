package gus06.entity.gus.java.compiler.v2;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, E, V {

	public String creationDate() {return "20140724";}


	private Service findJavac;
	private Service buildListing;
	private Service handleProcess;
	private Service emptyDir;
	private Service handleOther;
	
	private File srcDir;
	private File binDir;
	private File libDir;
	private File jdkDir;
	private F filter;
	private Object output;
	
	private File javacFile;
	private File listingFile;
	
	

	public EntityImpl() throws Exception
	{
		findJavac = Outside.service(this,"gus.java.jdk.javacfile");
		buildListing = Outside.service(this,"gus.java.compiler.buildlisting");
		handleProcess = Outside.service(this,"gus.java.compiler.handleprocess.is");
		emptyDir = Outside.service(this,"gus.dir.op.empty");
		handleOther = Outside.service(this,"gus.java.compiler.handleotherfiles");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("srcDir")) {srcDir = (File) obj;return;}
		if(key.equals("binDir")) {binDir = (File) obj;return;}
		if(key.equals("libDir")) {libDir = (File) obj;return;}
		if(key.equals("jdkDir")) {jdkDir = (File) obj;return;}
		if(key.equals("filter")) {filter = (F) obj;return;}
		if(key.equals("output")) {output = obj;return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	public void e() throws Exception
	{
		preparePaths();
		
		String[] cmd = buildCmd();
		
		if(fullCompilation()) emptyBin();
		
		ProcessBuilder pb = new ProcessBuilder(cmd);
		pb.redirectErrorStream(true);

		Process pr = pb.start();
		handleProcess.p(new Object[]{pr,output});
		
		if(fullCompilation()) completeBin();
	}
	
	
	
	
	
	
	private void preparePaths() throws Exception
	{
		if(srcDir==null) throw new Exception("Src directory has not been initialized");
		if(binDir==null) throw new Exception("Bin directory has not been initialized");
		
		srcDir.mkdirs();
		binDir.mkdirs();
		
		if(!srcDir.isDirectory()) throw new Exception("Src directory not found: "+srcDir);
		if(!binDir.isDirectory()) throw new Exception("Bin directory not found: "+binDir);
		
		javacFile = findJavacFile();
		listingFile = findListingFile();
	}
	
	
	private void emptyBin() throws Exception
	{
		emptyDir.p(binDir);
	}
	
	
	private void completeBin() throws Exception
	{
		handleOther.p(new File[]{srcDir,binDir});
	}
	
	
	
	private String[] buildCmd() throws Exception
	{
		if(libDir!=null && libDir.isDirectory())
		
		return new String[]{
			javacFile.getAbsolutePath(),
			"-classpath",
			libDir.getAbsolutePath()+"/*",
			"-sourcepath",
			srcDir.getAbsolutePath(),
			"-d",
			binDir.getAbsolutePath(),
			"@"+listingFile.getAbsolutePath()
		};
		
		return new String[]{
			javacFile.getAbsolutePath(),
			"-sourcepath",
			srcDir.getAbsolutePath(),
			"-d",
			binDir.getAbsolutePath(),
			"@"+listingFile.getAbsolutePath()
		};
	}
	
	
	private File findListingFile() throws Exception
	{
		return (File) buildListing.t(new Object[]{srcDir,filter});
	}
	
	private File findJavacFile() throws Exception
	{
		if(jdkDir!=null && jdkDir.isDirectory())
			return (File) findJavac.t(jdkDir); 
		return (File) findJavac.g();
	}
	
	private boolean fullCompilation()
	{
		return filter==null;
	}
}
