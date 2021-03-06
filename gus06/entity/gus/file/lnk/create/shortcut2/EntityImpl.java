package gus06.entity.gus.file.lnk.create.shortcut2;

import java.io.File;
import java.util.HashMap;
import javax.swing.Icon;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150607";}

	
	private Service createShortcut;
	private Service iconToIco;
	private Service gifToIco;
	
	public EntityImpl() throws Exception
	{
		createShortcut = Outside.service(this,"gus.file.lnk.create.shortcut1");
		iconToIco = Outside.service(this,"gus.convert.icontoicofile");
		gifToIco = Outside.service(this,"gus.convert.giffiletoicofile");
	}


	public void p(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=3) throw new Exception("Wrong data number: "+t.length);
		
		File target = (File) t[0];
		File lnk = (File) t[1];
		Object icon = t[2];
		
		createLnk(target,lnk,toIco(icon));
	}
	
	
	private void createLnk(File target, File lnk, File ico) throws Exception
	{createShortcut.p(new File[]{target,lnk,ico});}
	
	
	
	private File toIco(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof File) return toIco((File) obj);
		if(obj instanceof Icon) return (File) iconToIco.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass());
	}
	
	
	
	private File toIco(File f) throws Exception
	{
		if(isExt(f,"ico")) return f;
		if(isExt(f,"gif")) return (File) gifToIco.t(f);
		
		throw new Exception("Invalid ico file: "+f);
	}
	
	private boolean isExt(File f, String ext)
	{return f.getName().toLowerCase().endsWith("."+ext);}
}
