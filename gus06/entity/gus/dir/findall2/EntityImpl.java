package gus06.entity.gus.dir.findall2;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160808";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input = (File) o[0];
		F filter = (F) o[1];
		
		List output = new ArrayList();
		
		File[] ff = input.listFiles();
		if(ff==null) return output;
		
		int nb = ff.length;
		for(int i=0;i<nb;i++)
		{
			Object element = ff[i];
			if(filter.f(new Object[]{element,input})) output.add(element);
		}
		return output;
	}
}
