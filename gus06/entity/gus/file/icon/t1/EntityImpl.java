package gus06.entity.gus.file.icon.t1;

import java.io.File;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150324";}


	private Service iconProvider;
	private Service getExtension;
	
	public EntityImpl() throws Exception
	{
		iconProvider = Outside.service(this,"gus.icon.provider");
		getExtension = Outside.service(this,"gus.file.getextension");
	}



	public Object t(Object obj) throws Exception
	{return findIcon((File) obj);}
	
	
	private Icon findIcon(File f) throws Exception
	{
		if(f==null || !f.exists()) return null;
		
		String ext = (String) getExtension.t(f);
		Icon icon = (Icon) iconProvider.t("FILE_"+ext);
		if(icon!=null) return icon;
		
		return FileSystemView.getFileSystemView().getSystemIcon(f);
	}
}
