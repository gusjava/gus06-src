package gus06.entity.gus.data.perform.subsequence0;

import gus06.framework.*;
import java.util.List;
import java.io.File;
import java.util.Arrays;
import java.io.PrintStream;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151119";}


	private Service stringSub;
	private Service listSub;
	private Service fileToArray;
	private Service getPrintStream;


	public EntityImpl() throws Exception
	{
		stringSub = Outside.service(this,"gus.data.string.subsequence0");
		listSub = Outside.service(this,"gus.data.list.subsequence0");
		fileToArray = Outside.service(this,"gus.file.read.string.array.autodetect");
		getPrintStream = Outside.service(this,"gus.io.printstream.autodetect");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof String) return stringSub.t(obj);
		if(input instanceof List) return listSub.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		String rule = (String) o[1];
		
		if(input instanceof StringBuffer)
		{
			StringBuffer sb = (StringBuffer) input;
			String output = (String) stringSub.t(new Object[]{sb.toString(),rule});
			
			sb.delete(0, sb.length());
			sb.append(output);
			return;
		}
		if(input instanceof List)
		{
			List list = (List) input;
			List output = (List) listSub.t(new Object[]{list,rule});
			
			list.clear();
			list.addAll(output);
			return;
		}
		if(input instanceof File)
		{
			File file = (File) input;
			String[] array = (String[]) fileToArray.t(file);
			List list = Arrays.asList(array);
			List output = (List) listSub.t(new Object[]{list,rule});
			int nb = output.size();
			
			PrintStream p = (PrintStream) getPrintStream.t(file);
			for(int i=0;i<nb;i++)
			{
				String line = (String) output.get(i);
				if(i<nb-1) p.println(line);
				else p.print(line);
			}
			p.close();
			return;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
