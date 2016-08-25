package gus06.entity.gus.sys.jdbcblob.perform.data.register.prepare;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160602";}
	
	public static final long DATA_MAXLENGTH = 200000000L;
	public static final long PREVIEW_MAXLENGTH = 1000000L;


	private Service getName0Ext;
	private Service readFile;
	private Service readPreview;


	public EntityImpl() throws Exception
	{
		getName0Ext = Outside.service(this,"gus.file.getname0ext");
		readFile = Outside.service(this,"gus.file.read.raw");
		readPreview = Outside.service(this,"gus.file.read.image.preview.raw");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof File) return prepareFile((File) obj);
		throw new Exception("Unsupported data type: "+obj.getClass().getName());
	}
	
	
	private Object[] prepareFile(File file) throws Exception
	{
		String[] n = (String[]) getName0Ext.t(file);
		String name = n[0];
		String type = n[1];
		
		byte[] content = (byte[]) readFile.t(file);
		byte[] preview = (byte[]) readPreview.t(file);
		
		if(content.length > DATA_MAXLENGTH)
			throw new Exception("Data is too big: "+content.length);
    	
		if(preview.length > PREVIEW_MAXLENGTH)
			throw new Exception("Preview is too big: "+preview.length);

		return new Object[]{name,type,preview,content};
	}
}
