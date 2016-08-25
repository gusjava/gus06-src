package gus06.entity.gus.dir.perform.searchfiles.byname_n;

import gus06.framework.*;
import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}
	
	private Service normalize;

	public EntityImpl() throws Exception
	{normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}
	
	private String normalize(String s) throws Exception
	{return (String) normalize.t(s);}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input =(File) o[0];
		String name = normalize((String) o[1]);
		
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
	
	private boolean filter(File file, String name) throws Exception
	{
		return normalize(file.getName()).equals(name);
	}
}
