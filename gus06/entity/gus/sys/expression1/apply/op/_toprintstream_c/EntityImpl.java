package gus06.entity.gus.sys.expression1.apply.op._toprintstream_c;

import gus06.framework.*;
import java.io.PrintStream;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160407";}


	private Service buildPrintStream;
	
	public EntityImpl() throws Exception
	{buildPrintStream = Outside.service(this,"gus.io.printstream.autodetect");}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return new T1((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private File f;
		public T1(File f) {this.f = f;}
		
		public Object t(Object obj) throws Exception
		{
			String charset = (String) obj;
			return new PrintStream(f,charset);
		}
	}
}
