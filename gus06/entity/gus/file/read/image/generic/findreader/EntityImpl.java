package gus06.entity.gus.file.read.image.generic.findreader;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}


	private Service readImage_image;
	private Service readImage_video;
	private Service readImage_pdf;
	private Service readImage_ico;
	private Service readImage_txt;
	private Service readImage_prop;
	
	private Service default0;
	

	
	public EntityImpl() throws Exception
	{
		readImage_image = Outside.service(this,"gus.file.read.image.from.image");
		readImage_video = Outside.service(this,"gus.file.read.image.from.video");
		readImage_pdf = Outside.service(this,"gus.file.read.image.from.pdf");
		readImage_ico = Outside.service(this,"gus.file.read.image.from.ico");
		readImage_txt = Outside.service(this,"gus.file.read.image.from.txt");
		readImage_prop = Outside.service(this,"gus.file.read.image.from.properties");
		
		default0 = Outside.service(this,"gus.file.read.image.generic.default0");
	}
	

	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return findReader(file);
	}
	
	
	private Service findReader(File file) throws Exception
	{
		String s = file.getName().toLowerCase();
		
		if(isImage(s)) return readImage_image;
		if(isVideo(s)) return readImage_video;
		if(en(s,"pdf")) return readImage_pdf;
		if(en(s,"ico")) return readImage_ico;
		if(en(s,"txt")) return readImage_txt;
		if(en(s,"properties")) return readImage_prop;
		
		return default0;
	}
	
	
	private boolean isImage(String s)
	{return en(s,"gif") || en(s,"png") || en(s,"jpg") || en(s,"jpeg") || en(s,"bmp");}
	
	private boolean isVideo(String s)
	{return en(s,"avi") || en(s,"mkv") || en(s,"wmv") || en(s,"flv") || en(s,"mp4");}
	
	
	private boolean en(String s, String ext)
	{return s.endsWith("."+ext);}
}
