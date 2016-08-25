package gus06.entity.gus.dir.perform.searchfiles.bypname;

import gus06.framework.*;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160406";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input =(File) o[0];
		String name = (String) o[1];
		
		List output = new ArrayList();
		handle(name,output,input);
		return output;
	}
	
	private void handle(String name, List output, File input) throws Exception
	{
		if(input.isDirectory()) handleDir(name,output,input);
		else if(filter(input,name)) output.add(input);
	}
	
	
	private void handleDir(String name, List output, File input) throws Exception
	{
		File[] ff = input.listFiles();
		for(int i=0;i<ff.length;i++)
		handle(name,output,ff[i]);
	}
	
	private boolean filter(File file, String name)
	{
		return file.getParentFile().getName().equals(name);
	}
}
