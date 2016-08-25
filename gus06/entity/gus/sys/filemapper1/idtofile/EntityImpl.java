package gus06.entity.gus.sys.filemapper1.idtofile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160212";}

	public static final String S = File.separator;
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File root = (File) o[0];
		String main = (String) o[1];
		String id = format((String) o[2]);
		
		return idToFile(root,main,id);
	}
	
	
	
	private File idToFile(File root, String main, String id) throws Exception
	{
		if(root==null || !root.isDirectory()) throw new Exception("Root undefined: " + root);
		if(id==null) throw new Exception("Id undefined: null");
		
		if(main==null) return new File(root,id);
		if(id.startsWith(S)) return new File(root,id);
		
		String path1 = id.replace(".",S)+S+main;
		return new File(root,path1);
	}
	
	
	private String format(String s)
	{return s.replace("\\",S).replace("/",S);}
}
