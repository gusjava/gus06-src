package gus06.entity.gus.file.filter.ext.istype.image;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20150628";}


	private Service bmp;
	private Service gif;
	private Service jpg;
	private Service png;
	private Service tiff;
	

	public EntityImpl() throws Exception
	{
		bmp = Outside.service(this,"gus.file.filter.ext.istype.image.bmp");
		gif = Outside.service(this,"gus.file.filter.ext.istype.image.gif");
		jpg = Outside.service(this,"gus.file.filter.ext.istype.image.jpg");
		png = Outside.service(this,"gus.file.filter.ext.istype.image.png");
		tiff = Outside.service(this,"gus.file.filter.ext.istype.image.tiff");
	}


	
	public boolean f(Object obj) throws Exception
	{return accept((File)obj);}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	public boolean accept(File f)
	{
		if(!f.isFile()) return false;
		return check(bmp,f) || check(jpg,f) || check(png,f) || check(gif,f) || check(tiff,f);
	}
	
	
	
	private boolean check(Service s, File f)
	{
		try{return s.f(f);}
		catch (Exception e)
		{
			Outside.err(this,"check(Service,File)",e);
			return false;
		}
	}
}