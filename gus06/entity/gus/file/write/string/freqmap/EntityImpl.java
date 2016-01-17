package gus06.entity.gus.file.write.string.freqmap;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;
import java.util.List;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151014";}

	
	private Service buildSortedKeys;

	public EntityImpl() throws Exception
	{
		buildSortedKeys = Outside.service(this,"gus.map.build.sortedkeys.byvalue");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Map map = (Map) o[1];
		
		List keys = (List) buildSortedKeys.t(map);
		int number = keys.size();
		
		PrintStream p = new PrintStream(file);
		for(int i=0;i<number;i++)
		{
			String key = (String) keys.get(number-i-1);
			Integer value = (Integer) map.get(key);
			p.println(value+"\t"+key);
		}
		p.close();
	}
}
