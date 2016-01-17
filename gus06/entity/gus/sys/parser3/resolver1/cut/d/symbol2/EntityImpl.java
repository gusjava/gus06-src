package gus06.entity.gus.sys.parser3.resolver1.cut.d.symbol2;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	private Service cut;
	
	public EntityImpl() throws Exception
	{cut = Outside.service(this,"gus.sys.parser3.resolver1.cut.symbol2");}

	
	public Object t(Object obj) throws Exception
	{
		List kk = (List) cut.t(obj);
		if(kk==null) return null;
		
		if(kk.size()!=2) throw new Exception("Parsing failed");
		
		List l1 = (List) kk.get(0);
		List l2 = (List) kk.get(1);
		return new List[]{l1,l2};
	}
}
