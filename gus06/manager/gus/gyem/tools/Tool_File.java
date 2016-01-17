package gus06.manager.gus.gyem.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Properties;

public class Tool_File {

	
	
	
	public static String text(File file) throws Exception
    {
    	FileReader fr = new FileReader(file);
        char[] a = new char[(int)file.length()];
        fr.read(a,0,(int)file.length());
        fr.close();
        return new String(a);
    }
	

	
	public static Properties prop(InputStream is) throws Exception
    {
    	Properties prop = new Properties();
        prop.load(is);
        is.close();
        return prop;
    }
    
    public static Properties prop(File file) throws Exception
    {
    	if(file==null || !file.exists()) return null;
    	return prop(new FileInputStream(file));
    }
    
    
    
    public static void writeProp(File file, Properties prop) throws Exception
    {
    	FileOutputStream fos = new FileOutputStream(file);
    	prop.store(fos,"");
    	fos.close();
    }
    
    
	
	
	/*
     * formattage du file path pour correspondre à l'OS
     */
    public static String pathOS(String path)
    {
	if(path.startsWith("<user.home>"))
	path = path.replace("<user.home>",System.getProperty("user.home"));
	
	if(path.startsWith("<java.home>"))
	path = path.replace("<java.home>",System.getProperty("java.home"));
	
    	String s = File.separator;
    	path = path.replace("\\",s).replace("/",s).replace(s+s,s);
    	if(path.startsWith(s)) path = path.substring(1);
    	if(path.endsWith(s)) path = path.substring(0,path.length()-1);

    	return path;
    }
    
    
	public static File newFileOS(String path)
    {return new File(pathOS(path)).getAbsoluteFile();}
    
	
    public static File newFileOS(File dir, String path)
    {return new File(dir,pathOS(path)).getAbsoluteFile();}
    
    
    
    public static String getResourceName(File file)
    {return getResourceName(file.getName());}
    
    
    
	public static String getResourceName(String name)
    {
        if(!name.contains(".")) return name;
        String[] n = name.split("\\.");
        int l = n[n.length-1].length();
        return name.substring(0,name.length()-1-l);
    }
	
	
	
	public static void copy(File in, File out) throws Exception
    {
    	if(in.equals(out)) return;
        out.getParentFile().mkdirs();
        
        FileInputStream fis = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out);
        
        FileChannel inputChannel = fis.getChannel();
        FileChannel outputChannel = fos.getChannel();
        
        outputChannel.transferFrom(inputChannel,0,in.length());
        
        fis.close();
        fos.close();
    }
}