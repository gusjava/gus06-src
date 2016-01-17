package gus06.entity.gus.entitydev.dirtosrcmd5.full;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150304";}
	

	private Service dirToSrc;
	private Service srcToMd5;
	private Service toClipboard;

	public EntityImpl() throws Exception
	{
		dirToSrc = Outside.service(this,"gus.entitydev.dirtosrc.full");
		srcToMd5 = Outside.service(this,"gus.crypto.hash.md5.hexa");
		toClipboard = Outside.service(this,"gus.clipboard.access.string");
	}
	
	public Object t(Object obj) throws Exception
	{
		String src = (String) dirToSrc.t(obj);
		return srcToMd5.t(src);
	}
}
