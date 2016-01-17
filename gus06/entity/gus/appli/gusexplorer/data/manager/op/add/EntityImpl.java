package gus06.entity.gus.appli.gusexplorer.data.manager.op.add;

import gus06.framework.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.io.File;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151017";}

	public static final String ACTION = "add";


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
		
		if(data instanceof File) return perform_add_file(list,(File) data);
		if(data instanceof List) return perform_add_list(list,(List) data);
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	private Object perform_add_list(List l, List l1) throws Exception
	{
		if(l1.isEmpty()) return null;
		if(l1.size()==1)
		{
			File f = (File) l1.get(0);
			return perform_add_file(l,f);
		}
		
		List l1_ = new ArrayList();
		for(int i=0;i<l1.size();i++)
		{
			File f = file((File) l1.get(i));
			if(perform_add_file(l,f)!=null) l1_.add(f);
		}
		
		Map m = new HashMap();
		m.put("action",ACTION);
		m.put("list",l1_);
		
		return m;
	}
	
	private Object perform_add_file(List l, File f) throws Exception
	{
		f = file(f);
		if(found(l,f)) return null;
		
		l.add(f);
		int index = index(l,f);
		
		Map m = new HashMap();
		
		m.put("action",ACTION);
		m.put("index",""+index);
		m.put("file",f);
		
		return m;
	}
	
	
	
	private File file(File f) throws Exception
	{return (File) extractPath.t(f);}
	
	private int index(List l, File f)
	{return l.indexOf(f);}
	
	private boolean found(List l, File f)
	{return index(l,f)>=0;}
}
