package gus06.entity.gus.tostring.desc.short1;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;
import java.awt.Image;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}


	private Service shortString;
	private Service colToString;
	private Service mapToString;
	private Service arrayToString;
	private Service fileToString;
	private Service imageToString;
	private Service renderedImageToString;
	

	public EntityImpl() throws Exception
	{
		shortString = Outside.service(this,"gus.tostring.desc.short1.string");
		colToString = Outside.service(this,"gus.tostring.desc.short1.collection");
		mapToString = Outside.service(this,"gus.tostring.desc.short1.map");
		arrayToString = Outside.service(this,"gus.tostring.desc.short1.array");
		fileToString = Outside.service(this,"gus.tostring.desc.short1.file");
		imageToString = Outside.service(this,"gus.tostring.desc.short1.image");
		renderedImageToString = Outside.service(this,"gus.tostring.desc.short1.renderedimage");
	}


	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "null";
		
		if(obj instanceof Number) return ""+obj;
		if(obj instanceof Boolean) return ""+obj;
		if(obj instanceof String) return shortString.t(obj);
		if(obj instanceof Collection) return colToString.t(obj);
		if(obj instanceof Map) return mapToString.t(obj);
		if(obj instanceof Object[]) return arrayToString.t(obj);
		if(obj instanceof File) return fileToString.t(obj);
		if(obj instanceof Image) return imageToString.t(obj);
		if(obj instanceof RenderedImage) return renderedImageToString.t(obj);
		
		return className(obj);
	}
	
	private String className(Object obj)
	{return obj.getClass().getSimpleName();}
}
