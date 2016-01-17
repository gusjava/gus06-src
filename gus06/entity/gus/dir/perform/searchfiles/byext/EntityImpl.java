package gus06.entity.gus.dir.perform.searchfiles.byext;

import gus06.framework.*;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151202";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input =(File) o[0];
		String ext = ((String) o[1]).toLowerCase();
		
		List output = new ArrayList();
		handle(ext,output,input);
		return output;
	}
	
	private void handle(String ext, List output, File input) throws Exception
	{
		if(input.isDirectory()) handleDir(ext,output,input);
		else if(filter(input,ext)) output.add(input);
	}
	
	
	private void handleDir(String ext, List output, File input) throws Exception
	{
		File[] ff = input.listFiles();
		for(int i=0;i<ff.length;i++)
		handle(ext,output,ff[i]);
	}
	
	private boolean filter(File file, String ext)
	{
		return file.getName().toLowerCase().endsWith("."+ext);
	}
}
