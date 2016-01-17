package gus06.entity.gus.clipboard.access;

import gus06.framework.*;
import java.awt.Image;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, P, G {

	public String creationDate() {return "20150530";}


	private Service accessImage;
	private Service accessListFiles;
	private Service accessString;


	public EntityImpl() throws Exception
	{
		accessImage = Outside.service(this,"gus.clipboard.access.image");
		accessListFiles = Outside.service(this,"gus.clipboard.access.listfiles");
		accessString = Outside.service(this,"gus.clipboard.access.string");
	}

	
	public Object g() throws Exception
	{
		Object string = accessString.g();
		if(string!=null) return string;
		
		Object list = accessListFiles.g();
		if(list!=null) return list;
		
		return accessImage.g();
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof String) {accessString.p(obj);return;}
		if(obj instanceof Image) {accessImage.p(obj);return;}
		if(obj instanceof List) {accessListFiles.p(obj);return;}
		if(obj instanceof File) {accessListFiles.p(obj);return;}
		if(obj instanceof File[]) {accessListFiles.p(obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
