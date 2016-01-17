package gus06.entity.gus.find.icon;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service stringToIcon;

	public EntityImpl() throws Exception
	{stringToIcon = Outside.service(this,"gus.convert.stringtoicon");}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Icon) return obj;
		if(obj instanceof File) return fileToIcon((File) obj);
		if(obj instanceof String) return stringToIcon((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private Icon fileToIcon(File file) throws Exception
	{return new ImageIcon(file.toURI().toURL());}
	
	
	private Icon stringToIcon(String id) throws Exception
	{return (Icon) stringToIcon.t(id);}
}
