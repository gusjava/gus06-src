package gus06.entity.gus.file.read.string.tree.autodetect;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160518";}


	private Service read;
	private Service buildTree;


	public EntityImpl() throws Exception
	{
		read = Outside.service(this,"gus.file.read.string.autodetect");
		buildTree = Outside.service(this,"gus.data.transform.string.tree1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String text = (String) read.t(obj);
		return buildTree.t(text);
	}
}
