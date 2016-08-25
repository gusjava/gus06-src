package gus06.entity.gus.system.javalibrarypath.modify;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import gus06.framework.*;

public class EntityImpl implements Entity, P, V {

	public String creationDate() {return "20150607";}


	
	public EntityImpl() throws Exception
	{}
	

	public void p(Object obj) throws Exception
	{
		setLibraryPath(toPath(obj));
	}


	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("set")) {setLibraryPath(toPath(obj));return;}
		if(key.equals("add")) {addLibraryPath(toPath(obj));return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	private String toPath(Object obj) throws Exception
	{
		if(obj instanceof String) return (String) obj;
		if(obj instanceof File) return ((File) obj).getAbsolutePath();
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private void setLibraryPath(String path) throws Exception
	{
		System.setProperty("java.library.path",path);
	 
		final Field field = ClassLoader.class.getDeclaredField("sys_paths");
		field.setAccessible(true);
		field.set(null,null);
	}
	
	
	private void addLibraryPath(String path) throws Exception
	{
		String path0 = System.getProperty("java.library.path");
		setLibraryPath(path+File.pathSeparator+path0);
	}
	
	
	
	
	/*
	 * changer directement la valeur de usr_paths dans la classe ClassLoader
	 */
	private void addLibraryPath2(String pathToAdd) throws Exception
	{
		final Field usrPathsField = ClassLoader.class.getDeclaredField("usr_paths");
		usrPathsField.setAccessible(true);
	 
		//get array of paths
		final String[] paths = (String[])usrPathsField.get(null);
	 
		//check if the path to add is already present
		for(int i=0;i<paths.length;i++)
		if(paths[i].equals(pathToAdd)) return;
	 
		//add the new path
		final String[] newPaths = Arrays.copyOf(paths,paths.length+1);
		newPaths[newPaths.length-1] = pathToAdd;
		usrPathsField.set(null,newPaths);
	}
}
