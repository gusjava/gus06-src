package gus06.entity.gus.file.write.image.all.findwriter;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150929";}

	
	private Service writeBmp;
	private Service writeJpg;
	private Service writeGif;
	private Service writePng;
	private Service writeTiff;
	
	private Service getExtension;
	
	
	
	public EntityImpl() throws Exception
	{
		writeBmp = Outside.service(this,"gus.file.write.image.jai.bmp");
		writeJpg = Outside.service(this,"gus.file.write.image.jai.jpg");
		writeGif = Outside.service(this,"gus.file.write.image.gif");
		writePng = Outside.service(this,"gus.file.write.image.png");
		writeTiff = Outside.service(this,"gus.file.write.image.tiff");
		
		getExtension = Outside.service(this,"gus.file.getextension.lowercase");
	}
	

	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		String ext = (String) getExtension.t(file);
		
		if(ext.equals("bmp")) return writeBmp;
		if(ext.equals("jpg")) return writeJpg;
		if(ext.equals("jpeg")) return writeJpg;
		if(ext.equals("gif")) return writeGif;
		if(ext.equals("png")) return writePng;
		if(ext.equals("tiff")) return writeTiff;
		
		throw new Exception("Writer not found for file "+file.getName());
	}
}
