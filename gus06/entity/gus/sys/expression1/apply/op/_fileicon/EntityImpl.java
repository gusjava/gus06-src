package gus06.entity.gus.sys.expression1.apply.op._fileicon;

import gus06.framework.*;
import java.io.File;
import javax.swing.Icon;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160209";}


	private Service findIcon;


	public EntityImpl() throws Exception
	{
		findIcon = Outside.service(this,"gus.file.icon.os");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return icon(toFile((String) obj));
		if(obj instanceof File) return icon((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Icon icon(File file) throws Exception
	{return (Icon) findIcon.t(file);}
	
	private File toFile(String s) throws Exception
	{return new File(s).getCanonicalFile();}
}
