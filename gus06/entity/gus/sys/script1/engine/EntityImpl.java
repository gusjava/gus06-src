package gus06.entity.gus.sys.script1.engine;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151111";}

	private Service engineFromText;
	private Service engineFromFile;

	public EntityImpl() throws Exception
	{
		engineFromText = Outside.service(this,"gus.sys.script1.engine.fromtext");
		engineFromFile = Outside.service(this,"gus.sys.script1.engine.fromfile");
	}

	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object src = o[0];
		Map context = (Map) o[1];
		
		return handle(src,context);
	}
	
	
	
	private Object handle(Object src, Map context) throws Exception
	{
		if(src instanceof G)		return handleG((G)src,context);
		if(src instanceof File)		return handleFile((File)src,context);
		if(src instanceof String)	return handleString((String)src,context);
		
		throw new Exception("Invalid source type: "+src.getClass().getName());
	}
	
	
	
	private Object handleG(G g, Map context) throws Exception
	{
		return handle(g.g(),context);
	}
	
	private Object handleFile(File f, Map context) throws Exception
	{
		return engineFromFile.t(new Object[]{f,context});
	}
	
	private Object handleString(String s, Map context) throws Exception
	{
		File f = new File(s).getCanonicalFile();
		if(f.isFile()) return handleFile(f,context);
		return engineFromText.t(new Object[]{s,context});
	}
}