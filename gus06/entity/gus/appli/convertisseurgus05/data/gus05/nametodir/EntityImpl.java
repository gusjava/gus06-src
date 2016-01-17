package gus06.entity.gus.appli.convertisseurgus05.data.gus05.nametodir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150525";}


	private Service nameToDir;
	private Service getRoot;
	
	
	public EntityImpl() throws Exception
	{
		nameToDir = Outside.service(this,"gus.entitydev.gus05.nametodir");
		getRoot = Outside.service(this,"gus.appli.convertisseurgus05.option.dirgus05");
	}


	
	public Object t(Object obj) throws Exception
	{
		File root = (File) getRoot.g();
		if(root==null) return null;
		return nameToDir.t(new Object[]{root,obj});
	}
}
