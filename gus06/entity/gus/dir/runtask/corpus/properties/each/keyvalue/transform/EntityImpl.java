package gus06.entity.gus.dir.runtask.corpus.properties.each.keyvalue.transform;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150926";}


	private Service listing;
	private Service chooser;
	private Service op;
	
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing0.ext.properties");
		chooser = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_h.tool.perform.chooser");
		op = Outside.service(this,"gus.file.properties.perform.each.keyvalue.transform");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File[] ff = (File[]) listing.t(dir);
		
		int size = ff.length;
		if(progress!=null) ((V)progress).v("size",""+size);
		
		T t = (T) chooser.g();
		if(t==null) {interrupt.add("*");return;}
		
		for(File f:ff)
		{
			op.p(new Object[]{f,t});
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
}
