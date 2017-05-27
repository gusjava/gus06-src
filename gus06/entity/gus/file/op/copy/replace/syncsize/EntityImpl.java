package gus06.entity.gus.file.op.copy.replace.syncsize;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20170527";}


	private Service copy;

	public EntityImpl() throws Exception
	{
		copy = Outside.service(this,"gus.file.op.copy.replace");
	}
	
		
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = o[1];
		
		if(!in.isFile()) throw new Exception("Invalid input file: "+in);
		
		if(!outOfSync(in,out)) return false;
		
		copy.p(new File[]{in,out});
		return true;
	}
	
	
	
	private boolean outOfSync(File in, File out)
	{
		if(!out.exists()) return true;
		return out.length() != in.length();
	}
}