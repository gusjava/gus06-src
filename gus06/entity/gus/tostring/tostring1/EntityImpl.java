package gus06.entity.gus.tostring.tostring1;

import gus06.framework.*;
import java.io.File;
import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140907";}


	private Service listToString;
	private Service setToString;
	private Service mapToString;
	
	private Service steToString;
	


	public EntityImpl() throws Exception
	{
		listToString = Outside.service(this,"gus.tostring.list");
		setToString = Outside.service(this,"gus.tostring.set");
		mapToString = Outside.service(this,"gus.tostring.map");
		
		steToString = Outside.service(this,"gus.tostring.stacktraceelement");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "null";
		
		if(obj instanceof String) return obj;
		if(obj instanceof Class) return ((Class)obj).getName();
		if(obj instanceof File) return ((File)obj).getAbsolutePath();
		if(obj instanceof JTextComponent) return ((JTextComponent) obj).getText();
		
		if(obj instanceof List) return listToString.t(obj);
		if(obj instanceof Set) return setToString.t(obj);
		if(obj instanceof Map) return mapToString.t(obj);
		
		if(obj instanceof StackTraceElement) return steToString.t(obj);
		
		return obj.toString();
	}
}
