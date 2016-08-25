package gus06.entity.gus.file.editor.main.filetoname;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140723";}


	
	public static final String JAR = "gus.file.editor.ext.jar";
	public static final String ZIP = "gus.file.editor.ext.zip";
	public static final String JAVA = "gus.file.editor.ext.java";
	public static final String GROOVY = "gus.file.editor.ext.groovy";
	public static final String PHP = "gus.file.editor.ext.php";
	public static final String JSON = "gus.file.editor.ext.json";
	public static final String CLASS = "gus.file.editor.ext.class1";
	public static final String PROPERTIES = "gus.file.editor.ext.properties";
	public static final String TXT = "gus.file.editor.ext.txt";
	public static final String CSV = "gus.file.editor.ext.csv";
	public static final String IMAGE = "gus.file.editor.ext.image";
	public static final String PDF = "gus.file.editor.ext.pdf";
	
	public static final String DIR = "gus.dir.explorer.simple";
	public static final String TOOL = "gus.file.editor.ext.tool";
	public static final String GUS = "gus.file.editor.ext.gus";
	public static final String DEFAULT = "gus.file.editor.default0";

	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(file==null) return null;
		
		if(file.isDirectory()) return DIR;
		
		String name = file.getName().toLowerCase();
		
		if(name.endsWith(".tool")) return TOOL;
		if(name.endsWith(".gus")) return GUS;
		
		if(name.endsWith(".jar")) return JAR;
		if(name.endsWith(".java")) return JAVA;
		if(name.endsWith(".groovy")) return GROOVY;
		if(name.endsWith(".php")) return PHP;
		if(name.endsWith(".json")) return JSON;
		if(name.endsWith(".class")) return CLASS;
		if(name.endsWith(".properties")) return PROPERTIES;
		if(name.endsWith(".csv")) return CSV;
		
		if(name.endsWith(".txt")) return TXT;
		if(name.endsWith(".log")) return TXT;
		if(name.endsWith(".html")) return TXT;
		if(name.endsWith(".htm")) return TXT;
		if(name.endsWith(".xhtml")) return TXT;
		if(name.endsWith(".css")) return TXT;
		if(name.endsWith(".js")) return TXT;
		if(name.endsWith(".sql")) return TXT;
		if(name.endsWith(".xml")) return TXT;
		if(name.endsWith(".yml")) return TXT;
		if(name.endsWith(".twig")) return TXT;
		if(name.endsWith(".ini")) return TXT;
		if(name.endsWith(".phtml")) return TXT;
		if(name.endsWith(".gsp")) return TXT;
		
		if(name.endsWith(".jpg")) return IMAGE;
		if(name.endsWith(".jpeg")) return IMAGE;
		if(name.endsWith(".bmp")) return IMAGE;
		if(name.endsWith(".gif")) return IMAGE;
		if(name.endsWith(".png")) return IMAGE;
		
		if(name.endsWith(".zip")) return ZIP;
		if(name.endsWith(".ods")) return ZIP;
		if(name.endsWith(".odt")) return ZIP;
		
		if(name.endsWith(".pdf")) return PDF;
		
		//if(name.endsWith(".chm")) return ZIP;
		
		return DEFAULT;
	}
}
