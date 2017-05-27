package gus06.entity.gus.icon.loader.outside;

import gus06.framework.*;
import java.io.File;
import javax.swing.ImageIcon;

public class EntityImpl implements Entity, T, R, G {

	public String creationDate() {return "20160914";}


	private File storeDir;

	public EntityImpl() throws Exception
	{
		File dir0 = (File) Outside.resource(this,"defaultdir");
		
		storeDir = new File(dir0,"myicons");
		storeDir.mkdirs();
	}
	
	
	public Object g() throws Exception
	{return storeDir;}
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	
	public Object r(String key) throws Exception
	{
		File gifFile = new File(storeDir,key+".gif");
		if(gifFile.isFile()) return new ImageIcon(gifFile.toURI().toURL());
		
		File pngFile = new File(storeDir,key+".png");
		if(pngFile.isFile()) return new ImageIcon(gifFile.toURI().toURL());
		
		return null;
	}
}
