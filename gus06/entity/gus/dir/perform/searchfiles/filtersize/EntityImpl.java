package gus06.entity.gus.dir.perform.searchfiles.filtersize;

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
		F filter = (F) o[1];
		
		List output = new ArrayList();
		handle(filter,output,input);
		return output;
	}
	
	private void handle(F filter, List output, File input) throws Exception
	{
		if(input.isDirectory()) handleDir(filter,output,input);
		else if(filter.f(new Long(input.length()))) output.add(input);
	}
	
	
	private void handleDir(F filter, List output, File input) throws Exception
	{
		File[] ff = input.listFiles();
		for(int i=0;i<ff.length;i++)
		handle(filter,output,ff[i]);
	}
}
