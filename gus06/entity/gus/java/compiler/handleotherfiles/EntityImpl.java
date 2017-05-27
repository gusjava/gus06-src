package gus06.entity.gus.java.compiler.handleotherfiles;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161108";}
	
	public static final F FILTER = new F(){
		public boolean f(Object obj) throws Exception
		{
			File f = (File) obj;
			if(!f.isFile()) return false;
			return !f.getName().endsWith(".java");
		}
	};


	private Service copy;

	public EntityImpl() throws Exception
	{
		copy = Outside.service(this,"gus.dir.op.copy.each.filtered");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		copy.p(new Object[]{o[0],o[1],FILTER});
	}
}
