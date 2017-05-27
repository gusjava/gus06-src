package gus06.entity.gus.sys.expression1.apply.op._fileicon;

import gus06.framework.*;
import java.io.File;
import javax.swing.Icon;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160209";}


	private Service findIcon;
	private Service buildFile;


	public EntityImpl() throws Exception
	{
		findIcon = Outside.service(this,"gus.file.icon.os");
		buildFile = Outside.service(this,"gus.sys.expression1.file.build");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof String) return icon(file((String) value, opMap));
		if(value instanceof File) return icon((File) value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private Icon icon(File file) throws Exception
	{return (Icon) findIcon.t(file);}
	
	private File file(String s, Map opMap) throws Exception
	{return (File) buildFile.t(new Object[]{s,opMap});}
}
