package gus06.entity.gus.sys.script1.engine;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;
import java.io.IOException;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151111";}


	private Service engineFromText;
	private Service engineFromFile;
	private Service buildFile;
	private Service getInside;

	public EntityImpl() throws Exception
	{
		engineFromText = Outside.service(this,"gus.sys.script1.engine.fromtext");
		engineFromFile = Outside.service(this,"gus.sys.script1.engine.fromfile");
		buildFile = Outside.service(this,"gus.sys.script1.tool.build.file");
		getInside = Outside.service(this,"gus.app.inside.script2");
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
		if(src==null) throw new Exception("Invalid source object: null");
		
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
		try
		{
			File f = (File) buildFile.t(new Object[]{s,context});
			if(f.isFile()) return handleFile(f,context);
		}
		catch(IOException e){}
		
		String script = (String) getInside.t(s);
		if(script!=null) return engineFromText.t(new Object[]{script,context});
		
		return engineFromText.t(new Object[]{s,context});
	}
}
