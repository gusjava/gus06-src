package gus06.entity.gus.sys.console.build.proc;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170313";}


	private Service cmdMap;
	
	public EntityImpl() throws Exception
	{
		cmdMap = Outside.service(this,"gus.system.env.path.map.cache");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String cmd = prepareCmd((String) o[0]);
		File root = (File) o[1];
		
		if(root==null) return Runtime.getRuntime().exec(cmd);
		if(!root.isDirectory()) throw new Exception("Invalid root dir: "+root);
		
		return Runtime.getRuntime().exec(cmd,null,root);
	}
	
	
	private String prepareCmd(String cmd) throws Exception
	{
		String[] nn = cmd.split(" ",2);
		if(nn.length==1) return nn[0];
		return firstPart(nn[0])+" "+nn[1];
	}
	
	
	
	private String firstPart(String c) throws Exception
	{
		Map map = (Map) cmdMap.g();
		if(!map.containsKey(c)) return c;
		
		File f = (File) map.get(c);
		return "\""+f.getAbsolutePath()+"\"";
	}
}
