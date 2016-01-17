package gus06.entity.gus.convert.inputstreamtofile;

import gus06.framework.*;
import java.io.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150812";}


	private Service tmpFile;
	private Service transfert;
	
	public EntityImpl() throws Exception
	{
		tmpFile = Outside.service(this,"gus.file.tmpfile");
		transfert = Outside.service(this,"gus.io.transfer");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		InputStream is = (InputStream) obj;
		File file = (File) tmpFile.g();
		
		FileOutputStream fos = new FileOutputStream(file);
		transfert.p(new Object[]{is,fos});
		return file;
	}
}
