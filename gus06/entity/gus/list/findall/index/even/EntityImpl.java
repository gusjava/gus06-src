package gus06.entity.gus.list.findall.index.even;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170116";}
	
	
	public Object t(Object obj) throws Exception
	{
		List input = (List) obj;
		
		List output = new ArrayList();
		int nb = input.size();
		
		for(int i=0;i<nb;i++) if(i%2==0)
		output.add(input.get(i));
		
		return output;
	}
}
