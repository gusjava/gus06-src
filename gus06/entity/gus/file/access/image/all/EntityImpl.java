package gus06.entity.gus.file.access.image.all;

import java.io.File;

import gus06.framework.*;


public class EntityImpl implements Entity, T{


	public String creationDate() {return "20150929";}
	
	
	
	private Service readImage;
	private Service writeImage;
	
	
	public EntityImpl() throws Exception
	{
		readImage = Outside.service(this,"gus.file.read.image.imageio");
		writeImage = Outside.service(this,"gus.file.write.image.all");
	}
	

	public Object t(Object obj) throws Exception
	{return new FileHolder((File)obj);}

	
	
	
	private class FileHolder implements P, G
	{	
		private File file;
		public FileHolder(File file){this.file = file;}
		
		public void p(Object obj) throws Exception
		{writeImage.p(new Object[]{file,obj});}
		
		public Object g() throws Exception
		{return readImage.t(file);}
	}

}
