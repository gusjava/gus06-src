package gus06.entity.gus.appli.gusexplorer.data.manager.op.init;

import gus06.framework.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151017";}

	public static final String ACTION = "init";


	private Service extractPath;
	
	public EntityImpl() throws Exception
	{
		extractPath = Outside.service(this,"gus.file.lnk.extract.path");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		Object data = o[1];
		
		return perform(list,(List) data);
	}
	
	
	private Map perform(List l, List l0) throws Exception
	{
		if(l0.isEmpty() && l.isEmpty()) return null;
		
		l.clear();
		for(int i=0;i<l0.size();i++)
		{
			File f = file((File) l0.get(i));
			if(!found(l,f)) l.add(f);
		}
		
		Map m = new HashMap();
		m.put("action",ACTION);
		
		return m;
	}
	
	private File file(File f) throws Exception
	{return (File) extractPath.t(f);}
	
	private int index(List l, File f)
	{return l.indexOf(f);}
	
	private boolean found(List l, File f)
	{return index(l,f)>=0;}
}
