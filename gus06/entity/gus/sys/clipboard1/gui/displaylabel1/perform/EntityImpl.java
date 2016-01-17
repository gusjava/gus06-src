package gus06.entity.gus.sys.clipboard1.gui.displaylabel1.perform;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151017";}


	private Service accessImage;
	private Service accessListFiles;
	private Service accessString;
	
	private Service convertImage;
	private Service convertString;
	private Service openList;


	public EntityImpl() throws Exception
	{
		accessImage = Outside.service(this,"gus.clipboard.access.image");
		accessListFiles = Outside.service(this,"gus.clipboard.access.listfiles");
		accessString = Outside.service(this,"gus.clipboard.access.string");
		
		convertImage = Outside.service(this,"gus.sys.clipboard1.g.listfiles.convertimage");
		convertString = Outside.service(this,"gus.sys.clipboard1.g.listfiles.convertstring");
		openList = Outside.service(this,"gus.awt.desktop.open.listfiles");
	}

	
	
	public void e() throws Exception
	{
		Object list = accessListFiles.g();
		if(list!=null) {openList.p(list);return;}
		
		Object img = accessImage.g();
		if(img!=null) {convertImage.p(img);return;}
		
		Object string = accessString.g();
		if(string!=null) {convertString.p(string);return;}
	}
}
