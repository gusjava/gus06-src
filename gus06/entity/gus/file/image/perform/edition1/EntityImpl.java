package gus06.entity.gus.file.image.perform.edition1;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20151005";}


	private Service findAccess;
	private Service dialog;
	
	public EntityImpl() throws Exception
	{
		findAccess = Outside.service(this,"gus.file.access.image.all");
		dialog = Outside.service(this,"gus.file.image.perform.edition1.dialog");
	}


	public boolean f(Object obj) throws Exception
	{
		File file = (File) obj;
		
		Object access = findAccess.t(file);
		
		Object img = ((G)access).g();
		img = dialog.t(img);
		
		if(img==null) return false;
		((P)access).p(img);
		return true;
	}
}
