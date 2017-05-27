package gus06.entity.gus.sys.expression1.apply.op._isfile_ext;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170211";}
	

	private Service getExt;

	public EntityImpl() throws Exception
	{
		getExt = Outside.service(this,"gus.file.getextension.lowercase");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new Filter(obj);
	}
	
	
	
	private class Filter implements F
	{
		private Object data;
		public Filter(Object data) {this.data = data;}
		
		public boolean f(Object obj) throws Exception
		{
			if(data==null) return false;
			if(!(data instanceof File)) return false;
			
			File file = (File) data;
			if(!file.isFile()) return false;
			
			String ext = (String) getExt.t(file);
			
			String rule = (String) obj;
			String[] nn = rule.split("\\|");
			
			for(String n:nn) if(ext.equals(n)) return true;
			return false;
		}
	}
}
