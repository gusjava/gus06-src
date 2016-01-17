package gus06.manager.gus.gyem.m020.p.prop.complete;

import java.io.File;
import java.util.Map;

import gus06.framework.P;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;

public class Module extends GyemSystem implements P {

	public void p(Object obj) throws Exception
	{
		Map prop = (Map) obj;
		
		if(!prop.containsKey(PROP_SEQ_PROP)) return;
		String sequence = (String) prop.get(PROP_SEQ_PROP);
		
		String[] nn = sequence.split(";");
		for(String n:nn) prop.putAll(loadFromPath(n));
	}

	
	
	private Map loadFromPath(String path) throws Exception
	{
		File file = (File) ((R) module(M102_R_FILEPROVIDER)).r(path);
		if(file==null || !file.isFile()) throw new Exception("File not found for path id="+path);
		return Tool_File.prop(file);
	}
}