package gus06.entity.gus.file.editor.main.builder.async;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141207";}


	private Service build;
	private Service fileToName;
	
	private Map map;
	
	
	public EntityImpl() throws Exception
	{
		build = Outside.service(this,"gus.sys.async.guibuilder.dataholder");
		fileToName = Outside.service(this,"gus.file.editor.main.filetoname");
		
		map = new HashMap();
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return fileToEditor(file);
	}
	
	
	
	private Object fileToEditor(File file) throws Exception
	{
		String name = fileToName(file);
		if(name==null) return null;
		
		if(!map.containsKey(name))
		{
			Object editor = build(name,file);
			map.put(name,editor);
			return editor;
		}
		
		Object editor = map.get(name);
		((P)editor).p(file);
		return editor;
	}
	
	
	
	private String fileToName(File file) throws Exception
	{return (String) fileToName.t(file);}
	
	
	private Object build(String name, Object data) throws Exception
	{return build.t(new Object[]{name,data});}
}
