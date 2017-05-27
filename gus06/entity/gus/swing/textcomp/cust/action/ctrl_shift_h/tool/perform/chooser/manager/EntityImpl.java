package gus06.entity.gus.swing.textcomp.cust.action.ctrl_shift_h.tool.perform.chooser.manager;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, G, R, V {

	public String creationDate() {return "20160828";}


	private Service dirToSet;
	private Service buildTrans;
	private Service transId;
	
	private File dir;
	private Map data;
	
	

	public EntityImpl() throws Exception
	{
		dirToSet = Outside.service(this,"gus.dir.children.dirtoset.name0");
		buildTrans = Outside.service(this,"gus.sys.script1.build2.t");
		transId = Outside.service(this,"gus.feature.build.t.id");
		
		File dir0 = (File) Outside.resource(this,"defaultdir");
		
		dir = new File(dir0,"scripts_h");
		dir.mkdirs();
	}
	
	
	public Object g() throws Exception
	{
		return dirToSet.t(dir);
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("dir")) return dir;
		if(key.equals("keys")) return new String[]{"dir"};
		
		if(key.startsWith("file_")) return file(key.substring(5));
		if(key.startsWith("trans_")) return trans(key.substring(6));
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("data")) {data = (Map) obj;return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	private File file(String key) throws Exception
	{
		File f = new File(dir,key+".gus");
		if(!f.exists()) f.createNewFile();
		return f;
	}
	
	private T trans(String key) throws Exception
	{
		File f = file(key);
		if(f.length()==0) return transId;
		return (T) buildTrans.t(new Object[]{f,data});
	}
}
