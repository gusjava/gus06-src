package gus06.entity.gus.appli.convertisseurgus05.data.gus06.check;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150525";}


	private Service check;
	private Service getRoot;
	
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.entitydev.nametodir.check");
		getRoot = Outside.service(this,"gus.appli.convertisseurgus05.option.dirgus06");
	}


	
	public boolean f(Object obj) throws Exception
	{
		File root = (File) getRoot.g();
		if(root==null) return false;
		return check.f(new Object[]{root,obj});
	}
}
