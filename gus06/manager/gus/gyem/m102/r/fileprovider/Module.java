package gus06.manager.gus.gyem.m102.r.fileprovider;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gus06.framework.G;
import gus06.framework.R;
import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;

public class Module extends GyemSystem implements R {

	private static final Pattern pattern_tag = Pattern.compile("<([^>]+)>");
	private static final Pattern pattern_move = Pattern.compile("\\[(-?[0-9]+)\\]");
	private static final int LOOKUP_LIMIT = 200;
	
	
	public Object r(String key) throws Exception
	{
		return searchFile(key,0);
	}

	
	
	private File searchFile(String info, int c) throws Exception
	{
		if(c>LOOKUP_LIMIT)
			throw new Exception("Infinite loop detected: stopping at value "+info);
		
		Map paths = (Map) ((G) module(M100_G_PATH)).g();
		
		if(paths.containsKey(info))
			return (File) paths.get(info);
		
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		
		if(info.startsWith("path."))
		{
			if(!prop.containsKey(info)) return null;
			String newInfo = (String) prop.get(info);
			if(newInfo.equals("null")) return null;
			
			File f = searchFile(newInfo,c+1);
			if(f==null) return null;
			paths.put(info,f);
			return f;
		}
		
		if(info.startsWith("["))
		{
			Matcher m = pattern_move.matcher(info);
			if(!m.find()) throw new Exception("Wrong syntax for path rule: ["+info+"]");
			if(m.start()>0) throw new Exception("Wrong syntax for path rule: ["+info+"]");
			
			int move = Integer.parseInt(m.group(1));
			String tail = info.substring(m.end());
			
			File f_tail = searchFile(tail,c+1);
			if(f_tail==null) return null;
			
			File file = moveFile(f_tail,move);
			return guslink(file);
		}

		if(info.startsWith("<"))
		{
			Matcher m = pattern_tag.matcher(info);
			if(!m.find()) throw new Exception("Wrong syntax for path rule: ["+info+"]");
			if(m.start()>0) throw new Exception("Wrong syntax for path rule: ["+info+"]");
			
			String tag = m.group(1);
			String tail = info.substring(m.end());
			
			File f_tag = searchFile(tag,c+1);
			if(f_tag==null) return null;
			
			File file = Tool_File.newFileOS(f_tag,tail);
			return guslink(file);
		}
		
		File file = Tool_File.newFileOS(info);
		return guslink(file);
	}
	
	
	
	
	private File moveFile(File file, int move)
	{
		if(!file.isAbsolute())
			file = file.getAbsoluteFile();
		
		int delta = move<0 ? move*-1 : deep(file)-move;
		
		for(int i=0;i<delta;i++)
			if(file.getParentFile()!=null)
		file = file.getParentFile();
		
		return file;
	}
	
	
	
	
	private int deep(File file)
	{
		int d = 0;
		while(file.getParentFile()!=null)
		{file = file.getParentFile();d++;}
		return d;
	}
	
	
	private File guslink(File f) throws Exception
	{return (File) ((T) module(M122_T_GUSLINK)).t(f);}
}