package gus06.entity.gus.find.s;

import gus06.framework.*;
import java.io.FileFilter;
import javax.swing.AbstractButton;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161216";}


	private Service buttonToS;

	public EntityImpl() throws Exception
	{
		buttonToS = Outside.service(this,"gus.convert.buttontos");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof S) return obj;
		if(obj instanceof AbstractButton) return buttonToS.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
