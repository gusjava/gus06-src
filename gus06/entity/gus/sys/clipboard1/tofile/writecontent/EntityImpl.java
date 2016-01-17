package gus06.entity.gus.sys.clipboard1.tofile.writecontent;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20151021";}
	

	private Service accessImage;
	private Service accessString;
	private Service accessFile;
	
	private Service writeImage;
	private Service writeString;
	private Service writeFile;
	
	
	public EntityImpl() throws Exception
	{
		accessImage = Outside.service(this,"gus.clipboard.access.image");
		accessString = Outside.service(this,"gus.clipboard.access.string");
		accessFile = Outside.service(this,"gus.clipboard.access.file");
		
		writeImage = Outside.service(this,"gus.file.write.image.all");
		writeString = Outside.service(this,"gus.file.write.string.autodetect");
		writeFile = Outside.service(this,"gus.file.write.file");
	}
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		File file = (File) obj;
		if(file.isDirectory()) throw new Exception("Invalid file: "+file);
		
		Object img = accessImage.g();
		if(img!=null)
		{
			file.getParentFile().mkdirs();
			writeImage.p(new Object[]{file,img});
			return true;
		}
		
		Object string = accessString.g();
		if(string!=null)
		{
			file.getParentFile().mkdirs();
			writeString.p(new Object[]{file,string});
			return true;
		}
		
		Object f = accessFile.g();
		if(f!=null)
		{
			file.getParentFile().mkdirs();
			writeFile.p(new Object[]{file,f});
			return true;
		}
		
		return false;
	}
}
